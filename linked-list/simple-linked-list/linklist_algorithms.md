INSERTION ALGORITHMS
    INSERTION AT BEGINNING OF LINKEDLIST
        step 1  create a node
        step 2 if start=NULL then 
                    start=node  
                    exit
                    end if
        step 3  temp=start
        step 4  start=node
        step 5 next[node]=temp
        step 6 exit
    INSERTION AT END OF LINKEDLIST
        step 1  create a node
        step 2 if start=NULL then 
                    start=node  
                    exit
                    end if
        step 3  temp=start
        step 4 repeat while next[temp]!=NULL
        step 5 temp=next[temp]
        step 6 end of while
        step 7 next[temp]=node
        step 8 exit
    INSERTION BEFORE ANY NODE (USING VALUE)
        step 1 start
        step 2 accept the value into val before we want to add node
        step 3 create a node
        step 4 temp=start
        step 5 repeat while (temp->num!=val)
            temp1=temp
            temp=next[temp]
        step 6 end of while
        step 7 next[temp1]=node
        step 8 next[node]=temp
        step 9 stop
    INSERTION AFTER ANY NODE (USING VALUE)
        step 1 start
        step 2 accept the value into val after we want to add node
        step 3 create a node
        step 4 temp=start
        step 5 repeat while (temp->num!=val)
            temp=next[temp]
        step 6 end of while
        step 7 next[node]=next[temp]
        step 8 next[temp]=node
        step 9 stop
    INSERTION OF A NODE AT A SPECIFIC POSITION
        step 1 start
        step 2 accpet the position no in 'n' which we want to insert the node
        step 3 create a new node
        step 4 temp=start
        step 5 repeat while (temp!=NULL)
            count+=1
            temp=next[temp]
        step 6 end of while
        step 7 if n> counter display "INVALID" and return
        step 8 temp=start and i=1
        step 9 repeat while(i<n)
            i=i+1
            temp1=temp
            temp=next[temp]
        step 10 end of while
        step 11 next[temp1]=node
        step 12 next[node]=temp
        step 13 stop
COUNT ALGORITHM
    step 1 start
    step 2 set count=0
    step 3 temp=start
    step 4 repeat while(temp!=NULL)
    step 5 count+=1
    step 6 temp=next[temp]
    step 7 end while
    step 8 print count
    step 9 end
DISPLAY ALGORITHM
    Step 1 creat a node
    Step 2 temp=start;
    Step 3 repeat while(temp!=NULL)
           print num[temp]
           temp=next[temp]
    Step 4 end while loop
    Step 5 Stop
DELETION ALGORITHMS
    DELETION AT BEGINNING   
        step 1 create a temp pointer  (struct linklist *temp)
        step 2 store the value of start in temp
        step 3 set start=next[start]
        step 4 set next[temp]=NULL
        step 5 unallocate memory pointer by temp free temp
        step 6 end
    DELETION AT END
        step 1 start
        step 2 create pointers temp and temp1
        step 3 temp = start
        step 4 repeat while next[temp]!=NULL
            temp1=temp
            temp=next[temp]
            end of while
        step 5 next[temp]= NULL
        step 6 free(temp)
        step 7 end
    DELETION BEFORE ANY NODE
        step 1 start
        step 2 create pointers temp,temp1,temp2
        step 3 input the value 'n' from user(value to be deleted)
        step 4 set temp=start
        step 5 set temp1=next[temp]
        step 6 set temp2=next[temp1]
        step 7 repeat while num[temp2]!=n
                temp=next[temp]
                temp1=next[temp]
                temp2=next[temp1]
            end of while
        step 8 set next[temp]=temp2
        step 9 set next[temp]=NULL
        step 10 free temp1
        step 11 stop
    DELETION AFTER ANY NODE
        step 1 start
        step 2 create pointers temp,temp1,temp2
        step 3 input the value 'n' from user(value to be deleted)
        step 4 set temp=start
        step 5 set temp1=next[temp]
        step 6 set temp2=next[temp1]
        step 7 repeat while num[temp]!=n
                temp=next[temp]
                temp1=next[temp]
                temp2=next[temp1]
            end of while
        step 8 set next[temp]=temp2
        step 9 set next[temp]=NULL
        step 10 free temp1
        step 11 stop
    DELETION OF A NODE AT A SPECIFIC POSITION
        step 1 start
        step 2 accpet the position no in 'n' which we want to insert the node
        step 3 create a new node
        step 4 temp=start
        step 5 repeat while (temp!=NULL)
            count+=1
            temp=next[temp]
        step 6 end of while
        step 7 if n> counter display "INVALID" and return
        step 8 temp=start and i=1
        step 9 repeat while(i<n)
            i=i+1
            temp1=temp
            temp=next[temp]
        step 10 end of while
        step 11 next[temp1]=next[temp]
        step 12 temp[next]=NULL
        step 13 free(temp)
        step 14 stop
EDIT A LINK LIST ALGORITHM
    step 1 start
    step 2 declare variables i=1,count=0,pos,num1
    step 3 create a pointer temp
    step 4 input the values of pos and num1
    step 5 set temp=start
    step 6 repeat while temp!=NULL 
            count=count+1
            temp=next[temp]
        end of while
    step 7 check if pos>count
            print INVALID INPUT and return 
        endif
    step 8 repeat while i<pos
                i=i+1
                temp=next[temp]
            end of while
    step 9  num[temp]=num1
    step 10 stop
REVERSE A LINK LIST ALGORITHM
    step 1    start
    step 2    create pointers temp,ptr and old
    step 3    set temp=start and ptr=NULL
    step 4    repeat while temp!=NULL
                    old=ptr
                    ptr=temp
                    temp=next[temp]
                    next[ptr]=old
                end of while
    step 5    start=ptr
    step 6    stop  



