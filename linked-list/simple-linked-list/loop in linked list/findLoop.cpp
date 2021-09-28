// length of loop

// It is known that Floyd’s Cycle detection algorithm terminates when fast and slow pointers meet at a common point. 
// It is also known that this common point is one of the loop nodes. Store the address of this common point in a 
// pointer variable say (ptr). Then initialize a counter with 1 and start from the common point and keeps on visiting 
// the next node and increasing the counter till the common pointer is reached again. 
// At that point, the value of the counter will be equal to the length of the loop.

// Algorithm
// 1) Find the common point in the loop by using the Floyd’s Cycle detection algorithm
// 2) Store the pointer in a temporary variable and keep a count = 0
// 3) Traverse the linked list until the same node is reached again and increase the count while moving to next node.
// 4) Print the count as length of loop

// Create a loop

#include<bits/stdc++.h>
using namespace std;
class Node
{
public:
    int data;
    Node *next;
};
// INSERT FUNCTION
void insertBeg(Node **head)
{
    Node *new_node = new Node;
    cout << endl
         << "enter data: ";
    cin >> new_node->data;
    new_node->next = (*head);
    (*head) = new_node;
}
int countNodes(Node *head){
    int count=0;
    Node *temp=head;
    while(temp!=NULL){
        count ++;
        temp=temp->next;
    }
    return count;
} 


void displayLoop(Node *head, int num){
    cout<<endl<<"Linked List is: "<<endl;
    int count = 0;
    Node *temp=head,*temp1;
    // to find the particular node
    // if found store it in temp1 
    // and if temp1== temp i.e. the last node of loop print the data and exit
    // else continue the iteration and print the items
    cout<<temp->data;
    temp=temp->next;
    while(temp!=NULL){
        if(count==num)
            temp1=temp;
        if(temp1==temp){
            cout<<"->"<<temp->data<<"->"<<temp->next->data<<"->"<<temp->next->next->data;
            return;
        }
        cout<<"->"<<temp->data;
        count++;
        temp=temp->next;
    }

}

// Loop Insertion function (basically to insert a loop)
// input the node num to create a loop (link the last of the simple linked list to 
// the element present at the the given node number say num)
// Traverse the linked list till that node number and store it in a pointer say temp
// traverse to reach the end of linked list
// set the next of the last of the linked list to the node temp
// break

void insertLoop(Node *head, int num){
    int count = 0;
    Node *temp=head;
    Node *temp1;
    // to find the particular node
    // if found store it in temp1 break the loop
    while(temp!=NULL){
        if(count==num){
            // cout<<"1"<<endl;
            temp1=temp;
            break;
        }
        
        count++;
        temp=temp->next;
    }
    // cout<<"2"<<endl;
    // cout<<"temp1 value"<<temp1->data<<endl;
    if(temp1==NULL)
    {
        cout<<"Element not found";
        // cout<<"3"<<endl;
        return;
    }
    // cout<<"4"<<endl;
    temp=head;
    // to reach end of linked list
    // cout<<"head node: "<<temp->data<<endl;
  
    while(temp->next!=NULL)
        temp=temp->next;
    // cout<<"5"<<endl;
    // cout<<"end node: "<<temp->data<<endl;
    // set the next of last node to the temp1
    temp->next=temp1;
    cout<<"Calling display loop function"<<endl;
    displayLoop(head,num);

}


// display linked list without loop function 
void display(Node *head)
{
    Node *temp = head;
    if (head != NULL)
    {
        cout << temp->data;
        temp = temp->next;
        while (temp != NULL)
        {
            cout << "->" << temp->data;
            temp = temp->next;
        }
    }
    else
    {
        cout<<"EMPTY!!";
        return;
    }
}

int lengthLoop(Node *head){
    Node *temp = head;  // for 1 hop
    Node *temp1= head; // for 2 hop
    while(temp && temp1 && temp1->next){
        temp=temp->next;
        temp1=temp1->next->next;
    if(temp==temp1)
        return lengthLoop(temp);
    }
    return 0;
}

int main()
{
    Node *head = NULL;
    int ch,num,len;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Insert a Loop in linked list";
        cout << endl
             << "3. Count Nodes in the loop";
        cout << endl
             << "4. Display";
        cout << endl
             << "5. End";
        cout << endl
             << "Enter choice: ";
        cin >> ch;
        switch (ch)
        {
        // Insert function call
        case 1:
            int insertChoice;
            do
            {
                cout << endl
                     << "1. INSERT AT BEGINNING";
                cout << endl<< "2. EXIT";
                cout << endl
                     << "Enter choice: ";
                cin >> insertChoice;
                switch (insertChoice)
                {
                case 1:
                    insertBeg(&head);
                    break;
                case 2:
                    cout << endl
                         << "EXIT INSERT FUNCTION" << endl;
                    break;
                default:
                    break;
                }
            } while (insertChoice != 2);
            break;
        // Insert Loop Function 
        case 2:
            cout<<"Enter the loop index number: ";
            cin>>num;
            insertLoop(head,num);
            break;
        // Count nodes in loop function
        case 3:
            len = lengthLoop(head);
            if(len == 0 )
                cout<<"No loop exists";
            else
                cout<<endl<<"Length of loop: "<<len<<endl;
            break;
        // display function call
        case 4:
            display(head);
            break;
        case 5:
            cout << "INVALID CHOICE";
            break;
        default:
            cout << "INVALID CHOICE";
            break;
        }
    } while (ch != 5);
}