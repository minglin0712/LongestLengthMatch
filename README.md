# LongestLengthMatch
How to find the longest length of the '1' sticks while given an n*n matrix which contains of '0' or '1'?

This is one of the most interesting problems about features match searching in a matrix. Probably it will be the coding test for the interview at some of the companies such as Google, Facebook, Microsoft, Amazon...etc. Let's give you an example of the graph as the file example1. And there's the solution about the example1 named example1withAns.

Like the grapch of example1, we could get the answer of length was 8.

Answer with Brute force method
As we all know about the procedure to find the greedy method of the problems. The first step to start was use the simplest method to complete an prototype solution. Though I haven't had the solution for the best ways. there's a thought process using Brute Force I could provide to you.

1. Find traversal path of each points while it was linked without any '0' until against the boundry of the arrays.
2. Use the list to record all of this traversal points and so that we could know which traversal path we have done.
3. Finally, use the list to record all of these traversal path. Return the longest of length.

We could transfer it to the psuedo code below.

    LongestMatch(Point start, Point end, List<List<Point>> array)
    1 if(start = end) return 0
    2 if(start is last) return getLongestLengthFromTraversalArrays
    3 
    4 for(check by the each of translate points)
    5   List traversalPath = getTraversal(start, end, translatePoint, traversalPath);
    6   if(array dosen't contains the list)
    7       array.add(traversalPath)
    8
    9  Go to the next checked points
    10 LongestMatch(start, end, array)
    
    getTraversal(start, end, translatePoint, traversalPath)
    1 nextPoint = start.translate(translatePoint)
    2 if(nextPoint were not out of boundary)
    3     if(the value of nextPoint of array was '1')
    4     add the current point to the traversalPath
    5     recursive to did getTraversal(nextPoint, end, translatePoint, traversalPath)
    6 return the traversalPath
  
Finally, if we consider all the possible edge cases once we complete all the coding work, it will works as we hope!
We provide you an sample code which was not did the fully test using Java Language. Once I found the best method for this problems, I will update the record of this repositary.
