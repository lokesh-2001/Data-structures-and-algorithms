#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node *next;
};

Node *front = NULL, *rear = NULL;

void push();
void pop();
void traverse();

int main(){
    system("cls");
    int ch;
    cout<<endl<<"QUEUE";
    do
    {
        cout<<endl<<"1. PUSH";
        cout<<endl<<"2. POP";
        cout<<endl<<"3. TRAVERSE";
        cout<<endl<<"4. EXIT";
        cout<<endl<<"Enter your choice: ";
        cin>>ch;
        switch (ch)
        {
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
            traverse();
            break;
        case 4:
            cout<<endl<<"END";
            break;
        default:
            cout<<endl<<"WRONG CHOICE";
            break;
        }
    } while (ch != 4);
    return 0;} 
void push(){
    Node *new_node=new Node;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next=NULL;
    if(front==NULL){
        front=new_node;
        rear=new_node;
        return;
    }
    rear->next = new_node;
    rear = new_node;
}
void pop(){
    int data;
    Node *temp;
    if(front==NULL){
        cout<<endl<<"QUEUE EMPTY"<<endl;
        return;
    }
    temp=front;
    data=front->data;
    front=temp->next;
    temp->next = NULL;
    delete(temp);
    cout<<endl<<data<<" is deleted"<<endl;

}
void traverse(){
    Node *temp;
    if(front==NULL){
        cout<<"QUEUE EMPTY";
        return;
    }
    cout<<front->data;
    temp=front->next;
    while(temp!=NULL){
        cout<<"->"<<temp->data;
        temp=temp->next;
    }
    cout<<endl;
}
