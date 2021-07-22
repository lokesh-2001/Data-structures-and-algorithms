/*QUEUE OPERATIONS USING LINKED LIST*/
#include <stdio.h>
#include <malloc.h>
struct queue{
    int item;
    struct queue *next;};

typedef struct queue qu;
qu *front = NULL, *rear = NULL;

void push();
void pop();
void traverse();

int main(){

    int ch;
    printf("QUEUE APPLICATION:LINKED LIST:");
    do
    {
        printf("\n1.PUSH\n");
        printf("2.POP\n");
        printf("3.TRAVERSE\n");
        printf("4.EXIT\n");
        printf("enter your choice:");
        scanf("%d", &ch);
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
            printf("END OF QUEUE APPLICATION:");
            break;
        default:
            printf("YOU HAVE ENTERED WRONG CHOICE:");
        }
    } while (ch != 4);
    return 0;} 
void push(){
    qu *node;
    int x;
    printf("enter value for insertion:");
    scanf("%d", &x);
    node = (qu *)malloc(sizeof(qu));
    node->item = x;
    node->next = NULL;
    if (front == NULL)
    {
        front = node;
        rear = node;
        return;
    }
    rear->next = node;
    rear = node;}
void pop(){
    int N;
    qu *temp;
    if (front == NULL)
    {
        printf("QUEUE IS EMPTY");
        return;
    }
    temp = front;
    N = front->item;
    front = temp->next;
    temp->next = NULL;
    free(temp);
    printf("%d is deleted:", N);}
void traverse(){
    qu *temp;
    if (front == NULL)
        printf("QUEUE IS EMPTY");
    else
    {
        temp = front;
        printf("ELEMENTS IN QUEUE:");
        while (temp->next != NULL)
        {
            printf("%d ", temp->item);
            temp = temp->next;
        }
        printf("%d ", temp->item);
    }}
