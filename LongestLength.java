/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 0 0 0 0 0 0 0 0 0 0
 * 1 1 0 1 1 1 0 0 0 0
 * 1 0 1 0 0 0 0 0 0 0
 * 1 0 0 1 0 0 1 0 0 0
 * 1 0 0 0 1 1 0 0 0 0
 * 1 0 0 0 1 1 0 0 0 0
 * 1 0 0 1 0 0 0 0 0 0
 * 1 0 1 0 0 0 0 0 0 0
 * 1 1 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 *   
 * -1, 1  -1  1, -1
 * -1, 0   0  +1, 0
 * -1, 1  +1  1,  1 
 * @author lin541019
 */


public class LongestLength{
    public List<List<Point>>  matchArray;
    public static int[][] transPoints = {
        {-1, -1}, {-1, 0}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1} };
    public int[][] matrix;
    
    public LongestLength(int[][] arrays){
        Point start = new Point(0, 0);
        Point end = new Point(arrays.length, arrays.length);
        matrix = arrays;
        matchArray = new ArrayList();
        int length = longestMatch(start, end, matchArray);
        System.out.println("Longest length of stick : " + length);
    }
    
    public int longestMatch(Point start, Point end, List<List<Point>>  matchArray){
        if(start.equals(end)) return 0;
        //last point of matrix, then return the longest length of the traversal points list
        if((start.getX() + 1) == end.getX() && (start.getY() + 1) == end.getY())
            return getLongestLength(matchArray);
        // point traversal, and get the list of traversal points
        List<Point> list;
        for(int[] translate : transPoints){
            list = new ArrayList();
            list = getTraversal(start, end, translate, list);
            if(!matchArray.contains(list)) matchArray.add(list);
        }
        //in the end of row points, but not the last points of matrix
        if((start.getX() + 1) == end.getX() && (start.getY()!= end.getY() - 1) ){
            start.translate(0, 1);
            start.setLocation(0, start.getY());
        }else
            start.translate(1, 0);
        //do the recursive when not the end
        return longestMatch(start, end, matchArray);
    }
    
    public List<Point> getTraversal(Point start, Point boundary, int[] direction, List<Point> list){
        // boundary judgment
        Point nxtPoint = start;
        nxtPoint.translate(direction[0], direction[1]);
        if(nxtPoint.getX() >= 0 && nxtPoint.getX() < boundary.getX() &&
                nxtPoint.getY() >= 0 && nxtPoint.getY() < boundary.getY()){
            if(matrix[(int)nxtPoint.getX()][(int)nxtPoint.getY()] == 1){
                list.add(start);
                return getTraversal(nxtPoint, boundary, direction, list);
            }
        }
        return list;
    }
    
    public int getLongestLength(List<List<Point>>  matchArray){
        int length = 0;
        for(List<Point> ptArray : matchArray)
            length = ptArray.size() > length ? ptArray.size() : length;
        return length;
    }
}
