#include <bits/stdc++.h>
using namespace std;
class Node{
    public:
    int item;
    Node *next;
};

void push();
void pop();
void traverse();

Node *top = NULL,*start = NULL;

int main(){
    system("cls");
    int ch;
    cout<<endl<<"STACK APPLICATION"<<endl;
    do{
        cout<<endl<<"1. PUSH";
        cout<<endl<<"2. POP";
        cout<<endl<<"3. TRAVERSE";
        cout<<endl<<"4. EXIT";
        cout<<endl<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: push();break;
            case 2: pop();break;
            case 3: traverse();break;
            case 4: cout<<endl<<"END"; break;
            default: cout<<endl<<"WRONG CHOICE";break;

        }
    }while(ch!=4);
}
void push(){
    Node *new_node=new Node,*temp;
    int data;
    cout<<endl<<"enter data: ";
    cin>>new_node->item;
    new_node->next=NULL;
    if(top==NULL){
        top=start=new_node;
        return;
    }
    temp=start;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->next=new_node;
    top=new_node;
}
void pop(){
    int data;
    Node *temp1;
    Node *temp=start;
    if(top==NULL)
    {
        cout<<endl<<"Stack Empty";
        return;
    }
    if(top==start){
        data=top->item;
        cout<<data<<" is POPPED OUT";
        delete(top);
        top=NULL;
        start=NULL;
        return;
    }
    temp=start;
    while(temp->next!=NULL){
        temp1=temp;
        temp=temp->next;
    }
    data=top->item;
    cout<<data<<" is POPPED OUT";
    delete(temp);
    top=temp1;
    top->next=NULL;
}
void traverse(){
    Node * temp;
    if(start==NULL){
        cout<<endl<<"Stack is empty!!";
        return;
    }
    cout<<start->item;
    temp=start->next;
    while(temp!=NULL){
        cout<<"->"<<temp->item;
        temp=temp->next;
    }
}
void peep(){
    Node *temp;
    int pos;
    cout<<endl<<"Enter the position number to peep: ";
    cin>>pos;
    int i=1,c=0;
    temp=start;
    while(temp!=NULL){
        c++;
        temp=temp->next;
    }
    if(pos<c){
        cout<<endl<<"INVALID INPUT";
        return;
    }
    temp=start;
    while(i<pos){
        i++;
        temp=temp->next;
    }
    cout<<endl<<temp->item<<" is popped out";
} 
