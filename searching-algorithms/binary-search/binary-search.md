Binary Search is a searching algorithm for finding an element's position in a sorted array.

In this approach, the element is always searched in the middle of a portion of an array.

Binary search can be implemented only on a sorted list of items. If the elements are not sorted already, we need to sort them first.

Divide and Conquer Approach

Algorithm
BINARY_SEARCH(A, lower_bound, upper_bound, VAL)
Step 1: [INITIALIZE] SET BEG = lower_bound
END = upper_bound, POS = - 1
Step 2: Repeat Steps 3 and 4 while BEG <=END
Step 3: SET MID = (BEG + END)/2
Step 4: IF A[MID] = VAL
SET POS = MID
PRINT POS
Go to Step 6
ELSE IF A[MID] > VAL
SET END = MID - 1
ELSE
SET BEG = MID + 1
[END OF IF]
[END OF LOOP]
Step 5: IF POS = -1
PRINT "VALUE IS NOT PRESENT IN THE ARRAY"
[END OF IF]
Step 6: EXIT

Pseudo Code
    Using Iteration Method
        do until the pointers low and high meet each other.
            mid = (low + high)/2
            if (x == arr[mid])
                return mid
            else if (x > arr[mid]) // x is on the right side
                low = mid + 1
            else                       // x is on the left side
                high = mid - 1  
    Using recursive approach
        binarySearch(arr, x, low, high)
            if low > high
                return False 
            else
                mid = (low + high) / 2 
                if x == arr[mid]
                    return mid
                else if x > arr[mid]        // x is on the right side
                    return binarySearch(arr, x, mid + 1, high)
                else                               // x is on the right side
                    return binarySearch(arr, x, low, mid - 1)


Time Complexities
    Best case complexity: O(1)
    Average case complexity: O(log n)
    Worst case complexity: O(log n)
Space Complexity
    The space complexity of the binary search is O(1).
