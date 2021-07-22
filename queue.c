#include<stdio.h>
#include<stdlib.h>
#define MAX 5
void push();
void pop();
void traverse();
int front=-1, rear=-1;
int queue[MAX];

// MAIN FUNCTION
int main(){
    int ch;
    printf("QUEUE APPLICATION USING ARRAY");
    do{
        printf("\n1.PUSH\n");
        printf("\n2.POP\n");
        printf("\n3.TRAVERSE\n");
        printf("\n4.EXIT\n");
        printf("\n\nEnter your choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1: push();break;
            case 2: pop();break;
            case 3: traverse();break;
            case 4: printf("END OF QUEUE APPLICATION"); break;
            default: printf("YOU HAVE ENTERED WRONG CHOICE");
        }
    }while(ch!=4);
    return 0;}

// QUEUE FUNCTIONS
void push(){
    int item;
    if(rear>=MAX-1)
    {
        printf("QUEUE OVERFLOW!!!");
        return ;
    }
    printf("enter number for insertion: ");
    scanf("%d",&item);
    if(front==-1)
    {
        front=front+1;
        rear=rear+1;
    }
    else{
        rear+=1;
    }
    queue[rear]=item;}
void pop(){
    int item=0;
    if(front<0)
    {
        printf("UNDERFLOW!!");
        return ;
    }
    if(front==rear)
    {
        item=queue[front];
        queue[front]=NULL;
        front=-1;
        rear=-1;
        printf("%d is deleted",item);
        return ;
    }
    item=queue[front];
    queue[front]=NULL;
    front+=1;
    printf("%d is deleted",item);
}
void traverse(){
    int temp;
    if(front<0)
    {
        printf("UNDERFLOW!!");
        return;
    }
    temp=front;
    printf("ELEMENTS OF QUEUE ARE: ");
    while(temp<=rear){
        printf("%d",queue[temp]);
        temp+=1;
    }
}




