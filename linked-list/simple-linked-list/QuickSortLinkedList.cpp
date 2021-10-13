// quick sort on linked list
#include <bits/stdc++.h>
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

// display linked list function
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
        cout << "EMPTY!!";
        return;
    }
}
// Quick Sort 

// Function to return Last node of the linked list
Node * tail(Node *temp){
    while(temp!=NULL && temp->next!=NULL)
        temp=temp->next;
    return temp;
}

// Function to make partition and take the last element as pivot
Node *partition(Node* head,Node *end, Node *newHead, Node *newEnd){
    Node *pivot=end;
    Node *prev=NULL, *cur=head,*tail=pivot;
    // During partition both head and end of the list will be updated
    while(cur!=pivot){
        if(cur->data < pivot->data)
        {
            // First node that has a value less than the pivot 
            // it becomes the new head
            if((*newHead)==NULL)
                (*newHead)= cur;
            
            prev=cur;
            cur=cur->next;
        }
        else{
            // if current node is greater than pivot
            // Move currnet node to next of tail and change tail
            if(prev)
                prev->next=cur->next;
            Node *temp= cur->next;
            cur->next=NULL;
            tail->next=cur;
            tail=cur;
            cur=temp;
        }

    } 
    // if pivot is smallest in the list then it becomes head
    if((*newHead)==NULL)
        (*newHead)=pivot;

    // update newEnd to the current last node
    (*newEnd) = tail;
    return pivot; 
}

// here the sorting happens exclusive of the end node
Node *quickSortRec(Node *head, Node*end){

    // base condition
    if(!head || head==end)
        return head;
    
    Node *newHead=NULL,*newEnd=NULL;
    // Partition the list newhead and newend will be updated 
    // by the partition function
    Node *pivot= partition(head,end,&newHead,&newEnd);
    // if pivot is the smallest element - no need to recur further for the left part
    if(newHead!=pivot){
        // set the node before pivot as NULL
        Node *temp=newHead;
        while(temp->next!=pivot)
            temp=temp->next;
        temp->next=NULL;
        // recur for the list before pivot
        newHead=quickSortRecu(newHead,temp);
        // change next of the last node of the left half to picot
        temp=tail(newHead);
        temp->next=pivot;
    }
    // Recur for the list after the pivot element
    pivot->next=quickSortRec(pivot->next,newEnd);

    return newHead;
} 

// the main function for quick sort. this is a wrapper over recursive function quickSortRec()
void quickSort(Node **head)
{
    (*head)=quickSortRec((*head),tail(*head));
    return;
}


int main()
{
    Node *head = NULL;
    int ch;
    int result, result1;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Quick sort the linked list";
        cout << endl
             << "3. Display";
        cout << endl
             << "4. End";
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
                cout << endl
                     << "2. EXIT";
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
        // Quick Sort
        case 2:
            quickSort(&head);
            break;
        // display function call
        case 3:
            display(head);
            break;
        case 4:
            cout << "INVALID CHOICE";
            break;
        default:
            cout << "INVALID CHOICE";
            break;
        }
    } while (ch !=4 );
}
