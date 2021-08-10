SELECTION SORT
SELECTION SORT is a comparison sorting algorithm that is used to sort a random list of items in ascending order. The comparison does not require a lot of extra space. It only requires one extra memory space for the temporal variable.

This is known as in-place sorting. The selection sort has a time complexity of O(n2) where n is the total number of items in the list. The time complexity measures the number of iterations required to sort the list. The list is divided into two partitions: The first list contains sorted items, while the second list contains unsorted items.

By default, the sorted list is empty, and the unsorted list contains all the elements. The unsorted list is then scanned for the minimum value, which is then placed in the sorted list. This process is repeated until all the values have been compared and sorted.

Procedure
The first item in the unsorted partition is compared with all the values to the right-hand side to check if it is the minimum value. If it is not the minimum value, then its position is swapped with the minimum value.


Algorithm
step 1 - start
step 2 - get the size of the array (n)
step 3 - Partition the list into sorted and unsorted sections. The sorted section is initially empty while the unsorted section contains the entire list
step 4 - Pick the minimum value from the unpartitioned section and placed it into the sorted section
step 5 - Repeat the process (n – 1) times until all of the elements in the list have been sorted.
step 6 - end

Pseudo Code
n=size of array
for i=0 to i < n-1 and  increment i by 1
    smallest = i
    // inner loop is to find the smallest element in the array /// in each iteration
    for j=i+1 to j < n and increment j by 1
        if A[j] < A[smallest]
            smallest = A[j]
    end of for
    swap  A[i] and A[smallest]
end of for



* Selection sort is an in-place algorithm.
* It performs all computation in the original array and no other array is used.
* Hence, the space complexity works out to be O(1).

* The time complexity measures the number of steps required to sort the list.
* Worst case – this is where the list provided is in descending order. The algorithm performs the maximum number of executions which is expressed as [Big-O] O(n^2)
* Best case – this occurs when the provided list is already sorted. The algorithm performs the minimum number of executions which is expressed as [Big-Omega] ?(n^2)
* Average case – this occurs when the list is in random order. The average complexity is expressed as [Big-theta] ?(n^2)





