/*STACK OPERATIONS USING LINKED LIST(POINTER)*/
#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
struct stack
{
  int item;
  struct stack *next;
};
void push();
void pop();
void traverse();
void peep();

typedef struct stack st;
st *top = NULL,*start = NULL;
int main()
{
 int ch;
 printf("STACK APPLICATION USING POINTER:");
 do
 {
 printf("\n1.PUSH\n");
 printf("2.POP\n");
 printf("3.TRAVERSE\n");
 printf("4.PEEP\n");
 printf("5.EXIT\n");
 printf("enter your choice(1 to 5):");
 scanf("%d",&ch);
switch(ch)
 {
  case 1:push();break;
  case 2:pop();break;
  case 3:traverse();break;
  case 4:peep();break;
  case 5:printf("end of stack application");break;
  default:printf("you have entered wrong choice:");
 }
 }while(ch!=5);

}
void push()
{
 st *node,*temp;
 int data;
 printf("enter any data to PUSH into stack:");
 scanf("%d",&data);
 node =(st*)malloc(sizeof(st));
 node ->item = data;
 node ->next = NULL;
 if(top==NULL)
 {
  top = start = node;
  return;
 }
 temp=start;
 while(temp->next!=NULL)
	{
		temp=temp->next; //temp is last node
	}
	temp->next=node;
	top = node;
}
void pop()
{
 int data;
 st *temp,*temp1;
 if(top==NULL)
 {
  printf("stack is already empty\n");
  return;
 }
 if(top == start)
 {
 	data = top->item;
 	printf("%d is POP out",data);
 	free(top);
 	top = NULL;
 	start = NULL;
 	return ;
 }
 temp = start;
 while(temp->next!=NULL)
 {
		temp1=temp;
		temp=temp->next; //temp is last node
 }
	data = top->item;
	printf("%d is POP out",data);
	free(temp);
	top = temp1;
	top->next = NULL;
}
void traverse()
{
 st *temp;
 if(start==NULL)
  {
  	printf("stack is empty !!");
  	return ;
  }
   temp = start;
while(temp!=NULL)
  {
   printf("%d\n",temp->item);
   temp=temp->next;
  }
}
void peep(){
    st *temp;
    int pos;
    printf("Enter the position number to peep: ");
    scanf("%d",&pos);
    int i=1,c=0;
    temp=start;
    while(temp!=NULL){
        c+=1;
        temp=temp->next;
    }
    if(pos>c){
        printf("INVALID INpUT");
        return;
    }
    temp=start;
    while(i<(pos))
    {
        i+=1;
        temp=temp->next;
    }
    printf("%d is peeped out",temp->item);
} 

