// to implement all stack operations on the middle element of the stack
// use of doubly linked list
#include<bits/stdc++.h>
using namespace std;

class DoubleNode{
    public:
    DoubleNode *prev;
    DoubleNode *next;
    int data;
};
class stackLL{
    public:
    DoubleNode *head;
    DoubleNode *mid;
    int count;
};

// create stack (initialization)
stackLL *createStack(){
    stackLL * st = new stackLL();
    st->count = 0;
    return st;
}
void push(stackLL *st, int new_data){
    DoubleNode * node = new DoubleNode();
    node->data = new_data;
    // insertion at beginning
    node->prev = NULL;
    node->next = st->head;
    st->count ++;
    if(st->count ==1)
        st->mid = node;
    else{
        st->head->prev = node;

        // update mid if count is even
        if(!(st->count & 1))
            st->mid = st->mid->prev;
    }
    st->head = node;
}
int pop(stackLL *st){
    // underflow
    if(!st->count)
    {
        cout<<"UNDERFLOW!!"<<endl;
        return -1;
    }
    DoubleNode * head = st->head;
    int item = head->data;
    st->head = head->next;

    // if linked list doesn't become empty update prev of new head as null
    if(st->head != NULL)
        st->head->prev = NULL;
    st->count -=1;

    // update mid pointer when count is odd (move down the pointer)
    if((st->count)&1)
        st->mid = st->mid->next;

    free(head);
    return item; 
}

// to find the middle element of stack
int findMiddle(stackLL *st){
    if(st->count == 0){
        cout<<"Stack Empty!!"<<endl;
        return -1;
    }
    return st->mid->data;
}
// delete middle element
int deleteMiddle(stackLL *st){
    int temp = st->mid->data;
    st->mid->prev->next = st->mid->next;
    st->mid->next->prev = st->mid->prev->next;

    st->mid = st->mid->next;
    return temp;
}
int main(){
    stackLL* ms = createStack();
    push(ms, 11);
    push(ms, 22);
    push(ms, 33);
    push(ms, 44);
    push(ms, 55);
    push(ms, 66);
    push(ms, 77);
 
    cout << "Item popped is " << pop(ms) << endl;
    cout << "Item popped is " << pop(ms) << endl;
    cout << "Item popped is " << pop(ms) << endl;
    cout << "Middle Element is " << findMiddle(ms) << endl;
    cout << "Deleted Middle Element is "<<deleteMiddle(ms)<<endl;
    cout << "Middle Element is " << findMiddle(ms) << endl;
    return 0;
}

