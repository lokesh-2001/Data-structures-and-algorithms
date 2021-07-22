#include<stdio.h>
#include<conio.h>
#include<malloc.h>
#include<stdlib.h>

// insert function declarations
void insert();
void atbeg();
void atend();
void before();
void after();
void atpos();

void count();
void display();

//delete function declarations
void delete();
void del_atbeg();
void del_atend();
void del_before();
void del_after();
void del_atpos();
void sort();
void edit();
void reverse();

// declaration of doubly linked list
struct linklist{
    int num;
    struct linklist *prev;
    struct linklist *next;};
// structure variable initialization
struct linklist *start;

// display the linklist
void display()
{
    struct linklist *temp;
    temp=start;
    printf("%d",temp->num);
    temp=temp->next;
    while(temp!=NULL)
    {
        printf("<-->%d",temp->num);
        temp=temp->next;
    }   
}

// main function
int main (){
    int ch1;
    char choice1='y';
    start=NULL;
    system("cls");  // clrscr();
    printf("\t DOUBLY LINKED LIST");
    do
    {
        printf ("\n 1. INSERT     ");
        printf ("\n 2. DISPLAY     ");
        printf ("\n 3. DELETE      ");
        printf ("\n 4. EDIT        ");
        printf ("\n 5. COUNT NODES ");
        printf ("\n 6. SORTING      ");
        printf ("\n 7. REVERSE     ");
        printf ("\n 8. EXIT        ");

        printf ("\n\n Enter Your Choice = ");
        scanf("%d",&ch1);

        switch (ch1)
        {
            case 1:
                insert ();
                break;

            case 2:
                display ();
                break;
            case 3:
                delete();
                break;
            case 4:
                edit ();
                break;
            case 5:
                count ();
                break;
            case 6:
                sort();
                break;
            case 7:
                reverse ( );
                break;
            case 8:
                choice1='n';
                break;
            default:
                printf ("invalid choice");
        }
    } while (choice1== 'y');
    return 0;}	

// insert functions
void insert()
{
    int ch;
    char choice;
    do{
        printf("\n 1. ATBEG");
        printf("\n 2. ATEND");
        printf("\n 3. BEFORE");
        printf("\n 4. AFTER");
        printf("\n 5. ATPOS");
        printf("\n 6. EXIT\n");
        printf("\nEnter Your Choice: ");
        scanf("%d",&ch);
        switch (ch)
        {
        case 1:
            atbeg(); 
            break;
        case 2:
            atend(); 
            break;
        case 3:
            before(); 
            break;
        case 4:
            after(); 
            break;
        case 5:
            atpos(); 
            break;
        case 6:
            choice='n';
            printf("Your Linked List is: \n");
            display();  
            break;
        default:
            printf("INAVLID CHOICE");

        }

    }while(choice=='y');}
    void atbeg(){
        struct linklist *temp,*node;
        node =(struct linklist*)malloc(sizeof(struct linklist));
        printf("\n\n enter a data in Doubly Link List = ");
        scanf("%d",&node->num);
        node->next=NULL;
        node->prev = NULL;

        if(start==NULL)
        {
            start=node;
            return;
        }
        else
        {
            temp=start;
            start=node;
            node->next=temp;
            temp->prev = node;	
        }
    }
    void atend()
    {

        struct linklist *temp,*node;
        node=(struct linklist*)malloc(sizeof(struct linklist));
        printf("enter the data of node : ");
        scanf("%d",&node->num);
        node->next = NULL;
        node->prev = NULL;
        if(start==NULL)
        {
            start=node;
            return;
        }
        temp=start;
        while(temp->next!=NULL)
        {
            temp=temp->next; //temp is last node
        }
            temp->next = node;
            node->prev = temp;
    }
    void before()
    {
        int val;
        struct linklist *temp,*temp1,*node;
        printf("\nBefore which node you want to insert the node(value of the node): ");
        scanf("%d",&val);
        node=(struct linklist *) malloc (sizeof(struct linklist));
        printf("enter the data of node: ");
        scanf("%d",&node->num);
        node->next=NULL;
        node->prev=NULL;
        temp=start;
        while(temp->num!=val){
            temp1=temp;
            temp=temp->next;
        }
        temp1->next=node;
        node->prev=temp1;
        node->next=temp;
        temp->prev=node;

    }
    void after()
    {
        int val;
        struct linklist *temp,*node;
        printf("\nAfter which node you want to insert the node(value of the node): ");
        scanf("%d",&val);
        node=(struct linklist *) malloc (sizeof(struct linklist));
        printf("enter the data of node: ");
        scanf("%d",&node->num);
        node->next=NULL;
        temp=start;
        while(temp->num!=val){
            temp=temp->next;
        }
        node->next=temp->next;
        temp->next=node;
        node->prev=temp;
        temp->next->prev=node;
    }
    void atpos()
    {
        // temp1 is the previous node and temp is the current node
        int i=1,c=0,n;
        printf("Enter the position no: ");
        scanf("%d",&n);
        struct linklist *temp,*temp1,*node;
        node=(struct linklist *)malloc(sizeof(struct linklist));
        printf("Enter the data for the node: ");
        scanf("%d",&node->num);
        node->next=NULL;
        temp=start;
        while(temp!=NULL)
        {
            c+=1;
            temp=temp->next;
        }
        if(n>c)
        {
            printf("INVALID INPUT");
            return ;
        }
        temp=start;
        while(i<n){
            i+=1;
            temp1=temp;
            temp=temp->next;
        }
        temp1->next=node;
        node->prev=temp1;
        node->next=temp;
        temp->prev=node;

    }


// delete functions
void delete(){
    int ch;
    char choice;
    do{
        printf("\n 1. ATBEG");
        printf("\n 2. ATEND");
        printf("\n 3. BEFORE");
        printf("\n 4. AFTER");
        printf("\n 5. ATPOS");
        printf("\n 6. EXIT\n");
        printf("\nEnter Your Choice: ");
        scanf("%d",&ch);
        switch (ch)
        {
        case 1:
            del_atbeg(); 
            break;
        case 2:
            del_atend(); 
            break;
        case 3:
            del_before(); 
            break;
        case 4:
            del_after(); 
            break;
        case 5:
            del_atpos(); 
            break;
        case 6:
            choice='n';
            printf("Your Linked List is: \n");
            display();  
            break;
        default:
            printf("INAVLID CHOICE");

        }

    }while(choice=='y');    
}
    void del_atbeg(){
        struct linklist *temp;
        temp=start;
        start=start->next;
        start->prev=NULL;
        temp->next=NULL;
        temp->prev=NULL;
        free(temp);}
    void del_atend(){
		struct linklist *temp,*temp1;
		temp=start;
		while(temp->next!=NULL)
		{
			temp1=temp;
			temp=temp->next;
		}
		temp1->next=NULL;
        temp->prev=NULL;
		free(temp); }
    void del_before(){
        int i;
        struct linklist *temp, *temp1, *temp2;
        printf("\n before which node you want to delete: ");
        scanf("%d",&i);
        temp=start;
        temp1=temp->next;
        temp1->prev=temp;
        temp2=temp1->next;
        temp2->prev=temp1;
        while(temp2->num!=i)
        {
            temp->next->prev=temp;
            temp=temp->next;
            temp1=temp->next;
            temp1->prev=temp;
            temp2=temp1->next;
            temp2->prev=temp1;
        }
        temp->next=temp2;
        temp2->prev=temp;
        temp1->prev=NULL;
        temp1->next=NULL;
        free(temp1);}
    void del_after(){
        int n;
        struct linklist *temp,*temp1,*temp2;
        printf("\n after which node u want to delete: ");
        scanf("%d",&n);
                temp=start;
        temp1=temp->next;
        temp1->prev=temp;
        temp2=temp1->next;
        temp2->prev=temp1;
        while(temp->num != n) // only one change in this Line
        {
            temp->next->prev=temp;
            temp=temp->next;
            temp1=temp->next;
            temp1->prev=temp;
            temp2=temp1->next;
            temp2->prev=temp1;

        }
        temp->next=temp2;
        temp2->prev=temp;
        temp1->prev=NULL;
        temp1->next=NULL;
        free(temp1);}
	void del_atpos(){
			// temp1 is the previous node and temp is the current node
			int i=1,c=0,n;
			printf("enter the position no: ");
			scanf("%d",&n);

			struct linklist *temp,*temp1;
            temp=start;
			while(temp!=NULL){
				c=c+1;
				temp=temp->next;}
			if (n>c){
				printf("INVALID INPUT");
				return;}
			temp=start;
			while(i<n)
			{
				i+=1;
				temp1=temp;
				temp=temp->next;
                temp->prev=temp1;
			}
			temp1->next=temp->next;
            temp->next->prev=temp1;
			temp->next=NULL;
            temp->prev=NULL;
			free(temp);
			}


// count the number of nodes
void count()
{
	int count=0;
	struct linklist *temp;
	temp=start;
	while(temp!=NULL)
	{
		count+=1;
		temp=temp->next;
	}
	printf("\n\n total nodes are: %d",count);

}
    
// edit the link list
void edit(){
	int i=1,count=0,pos,num1;
	struct linklist *temp;
	printf("Enter the position Number: ");
	scanf("%d",&pos);
	printf("Enter the value to be changed: ");
	scanf("%d",&num1);
	temp=start;
	while(temp!=NULL)
	{
		count+=1;
		temp=temp->next;
	}
	if(pos > count)
	{
		printf("INVALID");
		return;
	}
	temp=start;
	while(i<pos)
	{
		i=i+1;
		temp=temp->next;
	}
	temp->num=num1;}
// reverse the lik list
void reverse(){
	struct linklist *temp,*ptr,*old;
	temp=start;
	ptr=NULL;
	while(temp!=NULL)
	{
		old=ptr;
		ptr=temp;
		temp=temp->next;
		ptr->next=old;
	}	
	start=ptr;}
//sort a link list
void sort(){
	int n;
	struct linklist *temp,*temp1;
	temp=start;
	while(temp==start)
	while(temp!=NULL)
	{
		temp1=temp->next;
		while(temp1!=NULL)
		{
			if(temp->num>temp1->num)
			{
				n=temp->num;
				temp->num=temp1->num;
				temp1->num=n;
			}
			temp1=temp1->next;
		}
		temp=temp->next;
	}}
