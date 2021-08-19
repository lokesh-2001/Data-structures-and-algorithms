STACK USING ARRAY
    INSERTION IN STACK PUSH OPERATION
        step 1 start
        step 2 check if top>=MAX_SIZE-1
                print "STACK OVERFLOW" and return
        step 3 input the value of item for insertion and store it in item
        step 4 increment top and set top[stack]=item
        step 5 stop
    DELETION IN STACK POP OPERATION
        step 1 start
        step 2 check if top < 0
                print "UNDERFLOW" and return
        step 3 set item to top[stack]
        step 4 display the popped value i.e. top of the stack (item)
        step 5 set top[stack]=NULL 
        step 6 decrement top
        step 7 stop
    TRAVERSING IN STACK
        step 1 start 
        step 2 check if top < 0
                print "UNDERFLOW" and return
        step 3 set temp = top
        step 4 repeat while temp>=0
                print the value of temp[stack] (stack value)
                decrement temp
            end of while
        step 5 stop
    PEEPING IN STACK
        step 1 start
        step 2 input the position no to be peeped and store it in pos
        step 3 check if top-pos+1 < 0
                print "INVALID" and return 
        step 4 print the peeped value i.e. value of stack at top-pos+1 
        step 5 stop
STACK USING LIKED LIST
    INSERTION IN STACK 
        step 1 start
        step 2 create a pointer temp of type structure
        step 3 input and store the tha data to be pushed (data)
        step 4 create a node of structure stack
        step 5 set item[node]=data and next[node]=NULL
        step 6 check if top==NULL (empty stack)
                set top=start=node and return
        step 7 set temp=start
        step 8 repeat while next[temp]!=NULL
                temp=next[temp]
            end of while
        step 9 set next[temp]=node and top=node
        step 10 stop
    DELETION IN STACK
        step 1 start
        step 2 check if stack is empty (top==NULL)
                print "STACK EMPTY" and return
        step 3 check if stack contains only one item (top==start)
                set data=item[top]
                print the value popped out (top of stack (data))
                free top and set top and start = NULL
                return
        step 4 create 2 pointers temp and temp1
        step 5 set temp=start
        step 6 repeat while next[temp]!=NULL
                set temp1=temp and temp=next[temp]
            end of while
        step 7 set data=item[top] 
        step 8 print the popped value(top of stack(data))
        step 9 free temp
        step 10 set top=temp1 and next[top]=NULL
        step 11 stop
    TRAVERSAL IN STACK
        step 1 start
        step 2 check if stack is empty
            print "STACK EMPTY" and return
        step 3 create a pointer temp
        step 4 set temp=start
        step 5 repeat while temp !=  NULL
                print item[temp] and set temp=next[temp]
            end of while
        step 6 stop 
    PEEPING IN STACK
        step 1 start
        step 2 input and store the position number to be peeped in pos
        step 3 create a pointer 
        step 4 declare and initialize variables of type int i=1 and c=0
        step 5 set temp=start
        step 6 repeat while temp!=  NULL
                increment c and set temp=next[temp]
            end of while
        step 7 check if pos>c
                print "INVALID INPUT" and return
        step 8 set temp = start
        step 9 repeat while i < pos   
                increment 1 and set  temp=next[temp]
        step 10 print the peeped value i.e. item[temp]
        step 11 stop

