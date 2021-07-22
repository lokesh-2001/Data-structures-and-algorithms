#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 5
int stack[MAX_SIZE];
int top=-1;     // stack is empmty
void push();
void pop();
void peep();
void traverse();
int main(){
    int ch;
    printf("Stack Application Menu \n");
    do
    {
        printf("\n1.PUSH\n");
        printf("2.POP\n");
        printf("3.PEEP \n");
        printf("4.TRAVERSE\n");
        printf("5.EXIT\n");
        printf("enter your choice(1 to 5) : ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:push();break;
            case 2:pop();break;
            case 3:peep();break;
            case 4:traverse();break;
            case 5:printf("end of stack application:");break;
            default:printf("you have entered wrong choice:");
        }
    }while(ch!=5);}

void push(){
    int item;
    if(top>=MAX_SIZE-1)
    {
        printf("STACK OVERFLOW!!!");
        return;
    }
    printf("enter the value to push: ");
    scanf("%d",&item);
    top++;
    stack[top]=item;}

void pop(){
    int item;
    if(top<0)
    {
        printf("UNDERFLOW!!");
        return;
    }
    item=stack[top];
    printf("%d is popped out",item);
    stack[top]=NULL;
    top--;
}

void traverse(){
    int i=0,temp;
    if(top<0)
    {
        printf("UNDERFLOW!!");
        return;
    }
    temp=top;
    printf("STACK ELEMENTS: ");
    while(temp>=0)
    {
        printf("\n%d",stack[temp]);
        temp-=1;
    }}

void peep(){
    int pos;
    printf("Enter the position number to peep: ");
    scanf("%d",&pos);
    if((top-pos+1)<0)
    {
        printf("SORRY NOT POSSIBLE!!");
        return;
    }
    printf("%d is PEEPED OUT AT LOCATION: %d\n",stack[top-pos+1]);}
