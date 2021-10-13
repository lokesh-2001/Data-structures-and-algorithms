
// More optimized solution
// O(1) time complexity and O(1) space complexity 
// store the min element found till cirrent insertion along with all the elements as a 
// reminder of a DUMMY_VALUE and the actual element as a multiple of the DUMMY_VALUE
// For example while pushing an element 'e' into the stack, store it as 
// "(e *DUMMY_VALUE +minFoundSoFar)", this way we know what was the minimum value present 
// in the stack at the time 'e' was being inserted

// to pop the actual value just return e/DUMMY_VALUE and set the new
// minimum as (minFoundSoFar % DUMMY_VALUE)

// following method will fail if we try to insert DUMMY_VALUE in the stack,
// so we have to make our selection of DUMMY_VALUE carefully

#include<bits/stdc++.h>
using namespace std;
// a special stack having peek() pop() and push() along with additional
// getMin() that returns minimum value in a stack without using extra space and all
// operations in O(1)

