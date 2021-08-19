STACK
======
* A stack is a non-primitive linear data structure.
* It's based on LIFO ( Last In First Out ) concept.
* New data addition ( PUSH ) and deletion from Stack
   (POP), both are executed at one end that is called 
    TOP Of the Stack (TOS).

Stack Implementation :
================
1. static implementation   
2. dynamic implementation
Algorithm for PUSH into Stack
=======================

step 1 - Start
step 2 - initialize / set top = -1
step 3 - Accept data in item to push into Stack
step 4 - if top >= MAX_SIZE-1
	display "Overflow" and return
step 5- end if
step 6- top = top + 1
step 7 - stack[top] = item
step 8 - Stop

Algorithm for POP from stack
====================

step 1 - Start
step 2 - if top < 0 
	display "Underflow / Stack is empty"
	and return 
step 3 - end if
step 4 - set item = stack[top]
step 5 - display item is popped out
step 6-  stack[top] = NULL
step 6 - top = top -1
step 7 - Stop

Algorithm to traverse the  Stack -
=====================
step 1 - Start
step 2 - if top < 0 
	display " Stack is empty "
	return 
step 3 - end if
step 4 - temp = top
step 5 - repeat while ( temp >= 0)
	display stack[temp]
	temp = temp - 1
step 6 - end of while
step 7 - Stop

Algorithm of PEEP in stack
==================
step 1 : Start
step 2 : Accept a position no. into N
step 3 : if ( TOP - N+1) < 0 Then
	Display "Not possible"
	return 
step 4 : end if
step 5 : display stack[TOP-N+1]
step 6 : Stop
