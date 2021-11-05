#include <bits/stdc++.h>
using namespace std;
class Node {
	public:
	int data;
	Node *next;
};
// INSERT FUNCTIONS
void insertBeg(Node **head){
    Node* new_node= new Node;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next = (*head);
    (*head) =  new_node;
}
void insertEnd(Node **head){
    Node* new_node= new Node;
    Node* last= *head;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next=NULL;
    if(*head==NULL){
        *head=new_node;
        return;
    }
    while(last->next!=NULL){
        last=last->next;
    }
    last->next=new_node;
    return;
}
void insertAfter(Node *head){
    int no;
    Node* new_node= new Node;
    Node* temp= head;
    cout<<endl<<"enter the node value after which the node is to be inserted: ";
    cin>>no;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next=NULL;
    while(temp->data!=no){
        temp=temp->next;
    }
    new_node->next=temp->next;
    temp->next=new_node;
}
void insertPrev(Node *head){  
    int no;
    Node* new_node= new Node;
    Node* temp= head;
    cout<<endl<<"enter the node value before which the node is to be inserted: ";
    cin>>no;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next=NULL;
    while(temp->next->data!=no){
        temp=temp->next;
    }
    new_node->next=temp->next;
    temp->next=new_node;
    

}
void insertatPos(Node *head){
    int no;
    Node *new_node=new Node;
    Node *temp1;
    Node * temp= head;
    cout<<endl<<"enter the node number at which the node is to be inserted: ";
    cin>>no;
    cout<<endl<<"enter data: ";
    cin>>new_node->data;
    new_node->next=NULL;
    int count=0;
    while(temp!=NULL){
        count++;
        temp=temp->next;
    }
    if(count<no){
        cout<<"INVALID OUTPUT";
        return;
    }
    temp=head;
    int i=1;
    while(i<no){
        i++;
        temp1=temp;
        temp=temp->next;
    }
    temp1->next=new_node;
    new_node->next=temp;

}


// Delete Functions
void deleteBeg(Node **head){
    Node *temp;
    temp=(*head);
    (*head)=(*head)->next;
    cout<<endl<<"THE FIRST NODE DELETED HAVING VALUE "<<temp->data<<endl;
    delete(temp);
}
void deleteEnd(Node **head){
    Node *temp1;
    Node *temp=*head;
    while(temp->next!=NULL){
        temp1=temp;
        temp=temp->next;
    }
    temp1->next=NULL;
    cout<<endl<<"THE LAST NODE DELETED HAVING VALUE "<<temp->data<<endl;
    delete(temp);

}
void deleteBefore(Node *head){
    int i;
    Node *temp=head,*temp1,*temp2;
    cout<<endl<<"Enter node value before which the node is to be deleted: ";
    cin>>i;
    temp1=temp->next;
    while(temp->next->data!=i)
    {
        temp=temp->next;
        temp1= temp->next;
    }
    temp->next=temp1->next;
    temp1->next=NULL;
    cout<<endl<<"THE NODE  HAVING VALUE "<<temp1->data<<" DELETED"<<endl;
    delete(temp1);
}
void deleteAfter(Node *head){
    int i;
    Node *temp=head,*temp1,*temp2;
    cout<<endl<<"Enter node value before which the node is to be deleted: ";
    cin>>i;
    temp1=temp->next;
    temp2=temp1->next;
    while(temp->data!=i)
    {
        temp=temp->next;
        temp1= temp->next;
        temp2= temp1->next;
    }
    temp->next=temp2;
    temp1->next=NULL;
    cout<<endl<<"THE NODE  HAVING VALUE "<<temp1->data<<" DELETED"<<endl;
    delete(temp1);
}
void deleteatPos(Node *head){
    int no;
    Node *temp1,*temp= head;
    cout<<endl<<"enter the node number at which the node is to be deleted: ";
    cin>>no;
    int count=0;
    while(temp!=NULL){
        count++;
        temp=temp->next;
    }
    if(count<no){
        cout<<"INVALID OUTPUT";
        return;
    }
    temp=head;
    int i=1;
    while(i<no){
        i++;
        temp1=temp;
        temp=temp->next;
    }
    temp1->next=temp->next;
    temp->next=NULL;
    cout<<endl<<"THE NODE  HAVING VALUE "<<temp->data<<" DELETED"<<endl;
    free(temp);

}

// sort link list function
void sort(Node *head){
    int n;
    Node *temp=head, *temp1;
    while(temp!=NULL){
        temp1=temp->next;
        while(temp1!=NULL)
        {
            if(temp->data>temp1->data)
            {
                // swap temp and temp1's data
                n=temp->data;
                temp->data=temp1->data;
                temp1->data=n;
            }
            temp1=temp1->next;
        }
        temp=temp->next;
    }
    cout<<endl<<"List is Sorted"<<endl;
}

// edit link list function
void edit(Node *head){
    int i=1,count=0,pos,num1;
    Node *temp=head;
    cout<<"Enter the position number whose value is to be changed: ";
    cin>>pos;
    cout<<"Enter the new value: ";
    cin>>num1;
    while(temp!=NULL){
        count++;
        temp=temp->next;
    }
    if(pos > count){
        cout<<endl<<"INVALID"<<endl;
        return;
    }
    temp=head;
    while(i<pos){
        i++;
        temp=temp->next;
    }
    temp->data=num1;
    cout<<endl<<"The data at the pos "<<pos<<" has been updated"<<endl;
}

// reverse link list function
void reverse(Node **head){
    Node *temp=*head,*ptr,*old;
    ptr=NULL;
    while(temp!=NULL){
        old=ptr;
        ptr=temp;
        temp=temp->next;
        ptr->next=old;
    }
    *head=ptr;
}
// count function
void count(Node *head){
    Node *temp=head;
    int count=0;
    while(temp!=NULL){
        count++;
        temp=temp->next;    
    }
    cout<<endl<<"The Total number of nodes are: "<<count<<endl;

}
// display linked list function
void display(Node *head){
    Node *temp=head;
    cout<<temp->data;
    temp=temp->next;
    while(temp!=NULL)
    {
        cout<<"->"<<temp->data;
        temp=temp->next;
    }
}   

int main(){
     Node * head= NULL;
     int ch;
     system("cls");
     do{
        cout<<endl<<"1. Insert";
        cout<<endl<<"2. Delete";
        cout<<endl<<"3. Display";
        cout<<endl<<"4. Count";
        cout<<endl<<"5. Edit";
        cout<<endl<<"6. Reverse";
        cout<<endl<<"7. Sort";
        cout<<endl<<"8. End";
        cout<<endl<<"Enter choice: ";
        cin>>ch;
        switch (ch)
        {
        // Insert function call
        case 1:
        int insertChoice;
            do{
                cout<<endl<<"1. INSERT AT BEGINNING";
                cout<<endl<<"2. INSERT AT END";
                cout<<endl<<"3. INSERT BEFORE A NODE";
                cout<<endl<<"4. INSERT AFTER A NODE";
                cout<<endl<<"5. INSERT AT A SPECIFIC POSITION";
                cout<<endl<<"6. EXIT INSERT";
                cout<<endl<<"Enter choice: ";
                cin>>insertChoice;
                switch (insertChoice)
                {
                case 1:
                    insertBeg(&head);
                    break;
                case 2:
                    insertEnd(&head);
                    break;
                case 3:
                    insertPrev(head);
                    break;
                case 4:
                    insertAfter(head);
                    break;
                case 5:
                    insertatPos(head);
                    break;

                case 6 :
                    cout<<endl<<"EXIT INSERT FUNCTION"<<endl;
                    break;
                default:
                    break;
                }
            }while(insertChoice!=6);
            break;
        // delete function call
        case 2:
            int deletechoice;
            do{
                cout<<endl<<"1. DELETE AT BEGINNING";
                cout<<endl<<"2. DELETE AT END";
                cout<<endl<<"3. DELETE BEFORE A NODE";
                cout<<endl<<"4. DELETE AFTER A NODE";
                cout<<endl<<"5. DELETE AT A SPECIFIC POSITION";
                cout<<endl<<"6. EXIT DELETE";
                cout<<endl<<"Enter choice: ";
                cin>>deletechoice;
                switch (deletechoice)
                {
                case 1:
                    deleteBeg(&head);
                    break;
                case 2:
                    deleteEnd(&head);
                    break;
                case 3:
                    deleteBefore(head);
                    break;
                case 4:
                    deleteAfter(head);
                    break;
                case 5:
                    deleteatPos(head);
                    break;

                case 6 :
                    cout<<endl<<"EXIT DELETE FUNCTION"<<endl;
                    break;
                default:
                    break;
                }
            }while(deletechoice!=6);
            break;
        // display function call
        case 3: 
        display(head);
        break;
        // count function call
        case 4 : 
        count(head);
        break;
        case 5 : 
        edit(head);
        break;
        case 6 : 
        reverse(&head);
        break;
        case 7 : 
        sort(head);
        break;
        case 8:
            cout<<"INVALID CHOICE";
            break;
        default:
            cout<<"INVALID CHOICE";
            break;
        }
    }while(ch!=8);
}