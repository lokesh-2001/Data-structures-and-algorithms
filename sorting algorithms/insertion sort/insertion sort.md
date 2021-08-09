INSERTION SORT
The Insertion sort, is a sorting algorithm which can be used to sort any linear data structure like a list or linked list. On simplicity, this is next to bubble sort, and it’s also pretty close to how humans manually sort something

Comparison based algorithm

It compares the current element with the elements on the left-hand side (sorted list). If the current element is greater than all the elements on its left-hand side, then it leaves the element in its place and moves on to the next element. Else it finds its correct position and moves it to that position by shifting all the elements, which are larger than the current element, in the sorted list to one position ahead.

Algorithm
* If the element is the first one, it is already sorted.
* Move to the next element of the list.
* Compare the current element with all elements in the sorted list.
* If the element in the sorted list is smaller than the current element, iterate to the next element. Otherwise, shift all the greater element in the list by one position towards the right.
* Insert the value at the correct position.
* Repeat until the complete list is sorted.
set i=1
start while loop for i < length of A
    set j=1
    start while for j > 0 and A[j-1] > A[j] 
        swap A[j] and A[j-1]
        decrement j by 1
    end of while
    increment i by 1
end while  


Pseudo Code 
i=1
while loop for i < length of A
    j=1
    while for j > 0 and A[j-1] > A[j] 
        swap A[j] and A[j-1]
        j=j-1
    end of while
    i=i + 1
end while  

Complexities
    worst time complexity O(n^2)
    best case time complexity O(n^2)
    Average time complexity O(n^2)
    Space Complexity O(1)

Characteristics
* Insertion sort takes maximum time for execution in the worst-case scenario where the given input elements are sorted in reverse order. It takes the least time in its best-case scenario where the elements are already sorted.
* Insertion sort follows an incremental approach in achieving its results.
* It is well preferred when the number of elements is less in number and most of the elements are in a sorted manner.
* The complexity involved in insertion sort can be reduced to O(log n) if the binary search method is adopted to search its sorted list each time to place an element from the unsorted number appropriately. This process can be referred to as Binary Insertion Sort.   

Note
* Due to its costly time complexity for copy operations, insertion sort is not typically used to sort a list.
* Insertion sort is an efficient way to insert a limited number of items into an already sorted list.
