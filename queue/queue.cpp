#include <bits/stdc++.h>
using namespace std;
#define MAX_SIZE 100
int array_queue[MAX_SIZE];
int front = -1,rear = -1; // queue empty
void push();
void pop();
void traverse();
int main(){
    int ch;
    system("cls");
    cout<<"QUEUE"<<endl;
    do{
        cout<<endl<<"1. PUSH"<<endl;
        cout<<"2. POP"<<endl;
        cout<<"3. TRAVERSE"<<endl;
        cout<<"4. EXIT"<<endl;
        cout<<"ENTER YOUR CHOICE"<<endl;
        cin>>ch;
        switch(ch){
            case 1: push();break;
            case 2: pop();break;
            case 3: traverse();break;
            case 4: cout<<"END";break;
            default: cout<<"WRONG CHOICE"<<endl;
        }
    }while(ch!=4);
}
void push(){
    int item;
    if(rear>=MAX_SIZE-1)
    {
        cout<<"QUEUE OVERFLOW!!!";
        return ;
    }
    cout<<"enter number for insertion: ";
    cin>>item;
    if(front==-1)
    {
        front=front+1;
        rear=rear+1;
    }
    else{
        rear+=1;
    }
    array_queue[rear]=item;}
void pop(){
    int item=0;
    if(front<0)
    {
        cout<<"UNDERFLOW!!";
        return ;
    }
    if(front==rear)
    {
        item=array_queue[front];
        array_queue[front]=NULL;
        front=-1;
        rear=-1;
        cout<<item<<" is deleted";
        return ;
    }
    item=array_queue[front];
    array_queue[front]=NULL;
    front+=1;
    cout<<item<<" is deleted";
}
void traverse(){
    int temp;
    if(front<0)
    {
        cout<<"UNDERFLOW!!";
        return;
    }
    temp=front;
    cout<<"ELEMENTS OF QUEUE ARE: ";
    while(temp<=rear){
        cout<<array_queue[temp]<<endl;
        temp+=1;
    }
}

