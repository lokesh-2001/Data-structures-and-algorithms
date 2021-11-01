#include <bits/stdc++.h>
using namespace std;
#define MAX_SIZE 100
int array_queue[MAX_SIZE];
int front = -1,rear = -1; // queue empty
void insert_last(){
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
    array_queue[rear]=item;
}
void insert_first(){
    int item;
    if(rear>=MAX_SIZE-1){
        cout<<"QUEUE OVERFLOW"<<endl;
        return;
    }
    cout<<"enter number for insertion: ";
    cin>>item;
    if(front==-1)
    {
        front=front+1;
        rear=rear+1;
    }
    else{
        front-=1;
    }
    array_queue[front]=item;

}
void delete_first(){
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
        cout<<item<<" is deleted"<<endl;
        return ;
    }
    item=array_queue[front];
    array_queue[front]=NULL;
    front+=1;
    cout<<item<<" is deleted"<<endl;
}
void delete_last(){
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
        cout<<item<<" is deleted"<<endl;
        return ;
    }
    item=array_queue[rear];
    array_queue[rear]=NULL;
    rear-=1;
    cout<<item<<" is deleted"<<endl;
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
        cout<<array_queue[temp]<<" ";
        temp+=1;
    }
}

int main(){
    int ch;
    system("cls");
    cout<<"QUEUE"<<endl;
    do{
        cout<<"1. INSERT AT BEGINNING"<<endl;
        cout<<"2. INSERT AT LAST"<<endl;
        cout<<"3. DELETE AT BEGINNING"<<endl;
        cout<<"4. DELETE AT LAST"<<endl;
        cout<<"5. TRAVERSE"<<endl;
        cout<<"5. EXIT"<<endl;
        cout<<"ENTER YOUR CHOICE"<<endl;
        cin>>ch;
        switch(ch){
            case 1: insert_first();break;
            case 2: insert_last();break;
            case 3: delete_first();break;
            case 4: delete_last();break;
            case 5: traverse();break;
            case 6: cout<<"END";break;
            default: cout<<"WRONG CHOICE"<<endl;
        }
    }while(ch!=6);
}
