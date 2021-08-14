QUICK SORT
Quick sort algorithm is one of the most widely used sorting algorithms. It follows a divide and conquer paradigm. We usually use Recursion in quicksort implementation. In each recursive call, a pivot is chosen, then the array is partitioned in such a way that all the elements less than pivot lie to the left and all the elements greater than pivot lie to the right.

Divide and Conquer algorithm

After every call, the chosen pivot occupies its correct position in the array which it is supposed to as in a sorted array. So with each step, our problem gets reduced by 2 which leads to quick sorting. Pivot can be an element. Example: last element of the current array or the first element of current array or random pivot etc.

Quick Sort Pivot Selection
For partitioning in quick sort

Algorithm
step 1 - choose the highest index value as pivot
step 2 - take two variables pointing to left and right of the list excluding pivot
    left points to low index
    right points to high index
step 3 - while left < pivot
            move right
step 4 - while right > pivot
            move left
step 5 - if step 3 and step 4 does not match swap left and right 
step 6 - if left=right 
            set pivot=left 

Pseudo Code
procedure partitionfunc(leftpointer,rightpointer,pivot)

    left = leftpointer
    right = rightpointer - 1

    while True do
        while A[++left] < pivot do
            // do nothing
        end while
        while right>0 && A[--right] > pivot do
            // do nothing
        end while

        if left>=right
            break
        else
            swap left and right
    end while
    swap left,rightpointer
    return left
end procedure

Quick Sort
Using pivot algorithm recursively, we end up with smaller possible partitions. Each partition is then processed for quicksort.

Algorithm

step 1 - make the right-most index as pivot
step 2 - partition the array using pivot
step 3 - quicksort left partition recursively
step 4 - quicksort right partition recursively

Pseudo Code

procedure quicksort(left,right)
    if right -  left < = 0
        return
    else
        pivot = A[right]
        partition=partitionfunc(left,right,pivot)
        quicksort(left,partition-1)
        quicksort(partition+1,right)
    end if
end procedure

* Quick Sort is also a good example of a recursive algorithm.
* We can express time complexity of quick sort by this recurrence relation:
    * T(n) = T(k) + T(n-k-1)+ ?(n).
    * T(k) -> recursion relation for elements left of pivot. k is a number of element smaller than the pivot.
    * T(k) -> recursion relation for elements right of pivot.
    * ?(n) -> It is for partition process.
* Time complexity of Quick Sort is O( n * log(n) ) in best and average case and O(n*n) in the worst case.
* Worst case is one when all elements of given array are smaller than pivot or larger than the pivot.
* Worst case can be easily eliminated by choosing random element as a pivot or best way is to choose median element as a pivot.
* It is an in-place sorting algorithm as it requires small additional storage space.
* Quick Sort is not a stable sort, which means the “equal” elements may not appear in the same order in the sorted array as they were in the unsorted array



Asymptotic Analysis of Quick Sort
* General relation for quick sort: T(n) = T(k) + T(n-k-1)+ ?(n).
* Best Case: T(n)= 2T(n/2)+ ?(n). Time complexity: O(n * log(n) ) 
* Best case occurs when a middle element is chosen as a pivot. It means a number of elements smaller than pivot are equal to the number of elements greater than the pivot.
* Average Case: T(n)= T(n/3)+T(2n/3)+ ?(n). Time complexity: O(n * log(n) ) 
* Average case can be considered when partition puts O(n/3) elements in one set and O(2n/13) elements in other set.
* Worst Case: T(n)= T(n-1)+ ?(n). Time complexity: O(n*n)
* Worst case occurs when all elements of given array are smaller than pivot or larger than pivot. Ex- Suppose array is already sorted and we choose the last element as a pivot.
* Algorithmic Paradigm: Divide and Conquer
* Space Complexity: O(n * log(n) ) in an average case.
* Sorting In Place: yes
* Stable: no


