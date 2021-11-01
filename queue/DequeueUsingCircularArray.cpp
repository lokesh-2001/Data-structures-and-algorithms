#include<bits/stdc++.h>
using namespace std;
#define MAX 100
class DequeCA{
    int arr[MAX];
    int front;
    int rear;
    int size;
    public:
        DequeCA(int size){
            front = -1;
            rear = -1;
            this->size = size;
        }
        void insertFront(int key);
        void insertRear(int key);
        void DeleteFirst();
        void DeleteRear();
        bool isFull();
        bool isEmpty();
        int getFront();
        int getRear();
};

bool DequeCA::isFull(){
    return ((front == 0 && rear == size-1) || front == rear+1);
}
bool DequeCA::isEmpty(){
    return (front == -1);
}
void DequeCA::insertFront(int item){
    if((front == 0 && rear == size-1) || front == rear+1){
        cout<<"OverFlow!!"<<endl;    
        return ;
    }
    if(front == -1)
    {
        front = 0;
        rear = 0;
    }
    else if(front == 0)
        front = size -1;
    else
        front -=1;
    arr[front] = item;
}   
void DequeCA::insertRear(int item){
    if((front == 0 && rear == size-1) || front == rear+1){
        cout<<"OverFlow!!"<<endl;    
        return ;
    }
    if(front == -1)
    {
        front = 0;
        rear = 0;
    }
    else if(rear == 0)
        rear = size - 1;
    else
        rear +=1;
    arr[rear] = item;
}   

void DequeCA::DeleteFirst(){
    if(front == -1)
    {
        cout<<"UnderFlow!!"<<endl;    
        return ;
    }
    if(front == rear){
        front = -1;
        rear = -1;
    }
    else{
        if(front == size - 1)
            front =0;
        else
            front+=1;
    }
}

void DequeCA::DeleteRear(){
    if(front == -1)
    {
        cout<<"UnderFlow!!"<<endl;    
        return ;
    }
    if(front == rear){
        front = -1;
        rear = -1;
    }
    else if(rear == 0)
        rear = size - 1;
    else
        rear-=1;
}
int DequeCA::getFront(){
    if(front == -1){
        cout<<"UnderFlow!!"<<endl;    
        return -1;
    }
    return arr[front];
}
int DequeCA::getRear(){
    if(front == -1||rear<0){
        cout<<"UnderFlow!!"<<endl;    
        return -1;
    }
    return arr[rear];
}
int main(){
    DequeCA dq(5);

    cout<<"Insert element at front end : 85"<<endl;
    dq.insertFront(85);
    cout<<"Insert element at front end : 69"<<endl;
    dq.insertFront(69);

    cout<<endl<<"Front Element: "<<dq.getFront()<<endl;
    cout<<endl<<"Rear Element: "<<dq.getRear()<<endl;

    cout<<"Insert element at rear end : 5"<<endl;
    dq.insertRear(5);
    cout<<"Insert element at rear end : 10"<<endl;
    dq.insertRear(10);
    
    cout<<endl<<"Front Element: "<<dq.getFront()<<endl;
    cout<<endl<<"Rear Element: "<<dq.getRear()<<endl;


    cout<<"Delete element at rear end : "<<endl;
    dq.DeleteRear();

    cout<<endl<<"Front Element: "<<dq.getFront()<<endl;
    cout<<endl<<"Rear Element: "<<dq.getRear()<<endl;

    cout<<"delete element at front end : "<<endl;
    dq.DeleteFirst();

    cout<<endl<<"Front Element: "<<dq.getFront()<<endl;
    cout<<endl<<"Rear Element: "<<dq.getRear()<<endl;

}
