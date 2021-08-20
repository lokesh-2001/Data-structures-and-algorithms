#include<stdio.h>
#include<malloc.h>
struct cll{
    int num;
    struct cll *next;};
typedef struct cll node;

node *start=NULL;
node *last=NULL;
node *insertfirst(node *);
node *insertlast(node *);
node *deletefirst(node *);
node *deletelast(node *);
void traverse();

int main(){
    int choice;
    printf("OPERTIONS ON CIRCULAR LINKED LIST:");
    do
    {
        printf("\n1.INSERT AT BEGINNING\n");
        printf("2.INSERT AT END\n");
        printf("3.DELETE AT BEGINNING\n");
        printf("4.DELETE AT END\n");
        printf("5.TRAVERSE\n");
        printf("6.EXIT\n");
        printf("enter your choice:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:start=insertfirst(start);break;
            case 2:start=insertlast(start);break;
            case 3:start=deletefirst(start);break;
            case 4:start=deletelast(start);break;
            case 5:traverse();break;
            case 6:printf("END OF CIRCULAR LINKED LIST APPLICATION\n");break;
            default:printf("YOU HAVE ENTERED WRONG CHOICE:\n");
        }
    }while(choice!=6);}
node *insertfirst(node *start){
    node *p;
    p=(node*)malloc(sizeof(node));
    printf("enter element:");
    scanf("%d",&p->num);
    if(start==NULL)
    {
        p->next=p;
        start=p;
        last=p;
    }
    else
    {
        p->next=start;
        start=p;
        last->next=start;   // Circular
    }
return(start);}
void traverse(){
    node *p;
    p=start;
    if(p==NULL)
        printf("list is empty:");
    else
    {
        while(p->next!=last)
        {
            printf("%d-->",p->num);
            p=p->next;
        }
        printf("%d-->\n",p->num);
}}
node * insertlast(node *start){
    node *p;
    p=(node*)malloc(sizeof(node));
    printf("enter the number:");
    scanf("%d",&p->num);
    if(start==NULL)
    {
        p->next=p;
        start=p;
        last=p;
    }
    else
    {
        last->next=p;
        p->next=start;
        last=p;
    }
    return(start);}
node *deletefirst(node *start){
    node *p;
    if(start==NULL)
        printf("LIST IS EMPTY:\n");
    else if(start->next==start)
        {
            printf("element deleted is %d",start->num);
            //free(start);
            start=NULL;
        }
    else
    {
        printf("element deleted is:%d",start->num);
        p=start->next;
        free(start);
        start=p;
        last->next=start;    
    }
    return(start);}
node *deletelast(node *start){
    node *p,*q;
    p = start;
    if(start==NULL)
        printf("LIST IS EMPTY:\n");
    else if(start->next==start)
        {
            printf("element deleted is %d",start->num);
            start=NULL;
        }
    else
    {
        while(p->next!=last)
        p=p->next;
        printf("ELEMENT DELETED IS %d",last->num);
        free(last);
        last=p;
        last->next=start;
    }
    return(start);}



