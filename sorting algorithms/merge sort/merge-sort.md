Merge sort is a very efficient sorting algorithm with a near-optimal number of comparison. The recursive algorithm used for merge sort comes under the category of divide and conquer technique. An array of n elements is split around its centre producing two smaller arrays. After these two arrays are sorted independently, they can be merged to produce the final sorted array. The process of splitting and merging can be carried recursively till there is only one element in the array. An array with 1 element is always sorted


Merge sort is based on the divide and conquer technique. With worst-case time complexity being Ο(n log n), it is one of the most respected algorithms. It first divides the array into equal halves and then combines them in a sorted manner.

Algorithm
    step 1 - if it is only one element, in the list (already sorted), return 
    step 2 - divide the list recursively into two halves until it can be no more divided
    step 3 - merge the smaller lists into new lists in sorted order

Pseudo Code

procedure mergesort( var a as array )
if ( n == 1 ) return a

var l1 as array = a[0] ... a[n/2]
var l2 as array = a[n/2+1] ... a[n]

l1 = mergesort( l1 )
l2 = mergesort( l2 )

return merge( l1, l2 )
end procedure

procedure merge( var a as array, var b as array )

var c as array
while ( a and b have elements )
    if ( a[0] > b[0] )
        add b[0] to the end of c
        remove b[0] from b
    else
        add a[0] to the end of c
        remove a[0] from a
    end if
end while

while ( a has elements )
    add a[0] to the end of c
    remove a[0] from a
end while

while ( b has elements )
    add b[0] to the end of c
    remove b[0] from b
end while

return c

end procedure

Complexities
    time- O(n*log2(n))
        We are dividing the array into two parts at each step till each subarray contains only one element, so the number of levels in this tree would be log2n, and at these different levels, while merging back the array, we will at max compare n elements. So the time complexity of the merge sort is θ(n*log2n).

        The time complexity of Merge Sort in worst, average, and best case is θ(n*log2n)  as merge sort always divides the array into two halves regardless of the fact that what is the present state of the array and takes linear time to merge the array.
    space- O(n)
        as we are using an auxiliary array to copy the left and right subarray. 
        But if we consider the stack memory then we are having a maximum of log2n function calls waiting in the stack which yields an extra space complexity of O(log2n). So total space complexity becomes O(n+log2n) as n is greater than log2n, we ignore the log2n part.

        There is another space-optimised approach to implement the merge sort called in-place merge sort in which instead of copying an array in left and right subarray we divide an array with help of pointers logically creating division in the original array by specifying the window for every recursive call. We shift the elements of the array to finally achieve the sorted configuration.

        Thus taking no extra space and having O(1) space complexity. But if we consider the stack memory then we have log2n function calls waiting in the stack memory and hence leads to O(log2n) space complexity.


The standard implementation of merge sort is outplace as it requires an extra space of O(n) for temporary arrays.