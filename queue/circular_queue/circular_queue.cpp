#include<bits/stdc++.h>
using namespace std;
#define MAX 100
int front= -1, rear= -1;
int circular_queue[MAX];
void push(){
    int item;
    if((front == (rear+1) % MAX))
    {
        cout<<endl<<"QUEUE OVERFLOW";
        return ;
    }
    cout<<"Enter data: ";
    cin>>item;
    if( front == -1)
    {
        front++;
        rear++;
    }
    else
    {
        rear = (rear+1) % MAX ;
    }
    circular_queue[rear]=item;
}
void pop(){
    int item=0;
    if(front == -1)
    {
        cout<<endl<<"UNDERFLOW!!";
    return ;
    }
    if(front==rear)
    {
    item=circular_queue[front];
    circular_queue[front] = 0;
    front=-1;
    rear=-1;
    cout<<endl<<item<<" is deleted";
    return ;
    }
    item=circular_queue[front];
    circular_queue[front] = 0;
    front = (front+1) % MAX ;
    cout<<endl<<item<<" is deleted";
}
void traverse(){
    int temp;
    if(front==-1)
    {
        cout<<endl<<"Queue is Empty";
        return;
    }
    temp=front;
    if(temp>rear)
    {
        while(temp>=(rear+1)%MAX)
        {
            cout<<"| "<<circular_queue[temp]<<" |";
        temp=(temp+1)%MAX;	
        }
        if(temp<=rear)
        {
            while(temp<=rear)
            {
                cout<<"| "<<circular_queue[temp]<<" |";
                temp=temp+1;
            }
        }
    }
    if(temp<=rear)
    {
        while(temp<=rear)
        {
            cout<<"| "<<circular_queue[temp]<<" |";
            temp=temp+1;
        }
    }
}

int main(){
    system("cls");
    int ch;
    cout<<endl<<"CIRCULAR QUEUE";
    do
    {
        cout<<endl<<"1. PUSH";
        cout<<endl<<"2. POP";
        cout<<endl<<"3. TRAVERSE";
        cout<<endl<<"4. EXIT";
        cout<<endl<<"Enter your choice: ";
        cin>>ch;
    switch(ch)
    {
    case 1:push();break;
    case 2:pop();break;
    case 3:traverse();break;
    case 4:cout<<endl<<"END";break;
    default:cout<<endl<<"WRONG CHOICE";break;
    }
    }while(ch!=4);
    return 0;
}
