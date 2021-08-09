BUBBLE SORT 
Bubble sort, also referred to as comparison sort, is a simple sorting algorithm that repeatedly goes through the list, compares adjacent elements and swaps them if they are in the wrong order. This is the most simplest algorithm and inefficient at the same time. Yet, it is very much necessary to learn about it as it represents the basic foundations of sorting.

COMPARISON BASED ALGORITHM

Algorithm: 
We compare adjacent elements and see if their order is wrong (i.e a[i] > a[j] for 1 <= i < j <= size of array; if array is to be in ascending order, and vice-versa). If yes, then swap them.

Explanation:
* Let us say, we have an array of length n. To sort this array we do the above step (swapping) for n - 1 passes.
* In simple terms, first, the largest element goes at its extreme right place then, second largest to the last by one place, and so on. In the ith pass, the ith largest element goes at its right place in the array by swapping.
* In mathematical terms, in ith pass, at least one element from (n - i + 1) elements from start will go at its right place. That element will be the ith (for 1 <= i <= n - 1) largest element of the array. Because in the ith pass of the array, in the jth iteration (for 1 <= j <= n - i), we are checking if a[j] > a[j + 1], and a[j] will always be greater than a[j + 1] when it is the largest element in range [1, n - i + 1]. Now we will swap it. This will continue until ith largest element is at the (n - i + 1)th position of the array.


Pseudo code  
bubbleSort(Arr[], size)
   // loop to access each array element
   for i=0 to size-1 do:
      // check if swapping occurs
      swapped = false
      // loop to compare array elements
      for j=0 to size-i-1 do:
         // compare the adjacent elements
         if Arr[j] > Arr[j+1] then
            // swap them
            swap(Arr[j], Arr[j+1])
            swapped = true
         end if
      end for
      // if no elements were swapped that means the array is sorted now, then break the loop.
      if(not swapped) then
         break
      end if
   end for
end

Complexity Analysis
In Bubble Sort, n-1 comparisons will be done in the 1st pass, n-2 in 2nd pass, n-3 in 3rd pass and so on. So the total number of comparisons will be,

(n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1
Sum = n(n-1)/2
i.e O(n2)

Time complexity- O(n^2)
Worst Case Time complexity (Big-O) - O(n^2)
Best Case Time complexity (Big-Omega) - O(n)
Average Time complexity (Big-Theta) - O(n^2)
Space Complexity- O(1)
because only a single additional memory space is required for temp variable

Advantages-
* The built-in ability to detect whether the list is sorted efficiently is the only advantage of bubble sort over other sorting techniques.
* When the list is already sorted (which is the best-case scenario), the complexity of bubble sort is only O(n).
* It is faster than other in case of sorted array and consumes less time to describe whether the input array is sorted or not.

Bubble sort is a stable algorithm.
A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted.

Bubble sort is an inplace algorithm.
An algorithm is said to be inplace if it does not need an extra space and produces an output in the same memory that contains the data by transforming the input ‘in-place’. However, a small constant extra space used for variables is allowed.

