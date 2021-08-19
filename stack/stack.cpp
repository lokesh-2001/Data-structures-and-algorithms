#include <bits/stdc++.h>
using namespace std;
#define MAX_SIZE 100
int array_stack[MAX_SIZE];
int top = -1; // stack empty
void push();
void pop();
void peep();
void traverse();
int main(){
    int ch;
    system("cls");
    cout<<"Stack"<<endl;
    do{
        cout<<endl<<"1. PUSH"<<endl;
        cout<<"2. POP"<<endl;
        cout<<"3. PEEP"<<endl;
        cout<<"4. TRAVERSE"<<endl;
        cout<<"5. EXIT"<<endl;
        cout<<"ENTER YOUR CHOICE"<<endl;
        cin>>ch;
        switch(ch){
            case 1: push();break;
            case 2: pop();break;
            case 3: peep();break;
            case 4: traverse();break;
            case 5: cout<<"END";break;
            default: cout<<"WRONG CHOICE"<<endl;
        }
    }while(ch!=5);
}
void push(){
    int item;
    if(top >= MAX_SIZE-1){
        cout<<endl<<"STACK OVERFLOW";
        return;
    }
    cout<<endl<<"enter the item value: ";
    cin>>item;
    top++;
    array_stack[top]=item;
}


void pop(){
    int item;
    if(top<0)
    {
        cout<<endl<<"UNDERFLOW!!";
        return;
    }
    item=array_stack[top];
    cout<<endl<<item<<" is popped out"<<endl;
    array_stack[top]=NULL;
    top--;
}

void traverse(){
    int i=0,temp;
    if(top<0)
    {
        cout<<endl<<"UNDERFLOW!!";
        return;
    }
    temp=top;
    cout<<endl<<"STACK ELEMENTS: "<<endl;
    while(temp>=0)
    {
        cout<<array_stack[temp]<<endl;
        temp-=1;
    }}

void peep(){
    int pos;
    cout<<endl<<"Enter the position number to peep: ";
    cin>>pos;
    if((top-pos+1)<0)
    {
        cout<<endl<<"SORRY NOT POSSIBLE!!";
        return;
    }
    cout<<array_stack[top-pos+1]<<" is PEEPED OUT AT LOCATION "<<pos<<endl;
}

