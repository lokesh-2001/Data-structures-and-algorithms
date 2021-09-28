// To remove duplicates from a linked list
// if linked list is sorted then 
// traverse the linked list from start. while traversing compare each node with its next node. if the data 
// of next node is same as the current node then delete the next node before deletion store the next pointer of the node
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

// function to check if the linked list is sorted
bool checkSorted(Node *head){
    Node *temp=head;
    if (head==NULL)
    return true;
    while(temp!=NULL){
        if(temp->data < temp->next->data)
            temp=temp->next;
        else
            return false;
    }

    return true;
}
void sort(Node **head){
    int n;
    Node *temp=*head, *temp1;
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
}

void removeDuplicates(Node *head){
    Node *temp=head;
    // Check if linked list is sorted
    bool sorted= checkSorted(temp);
    if (!sorted)
        sort(&temp);
    Node *temp1; //next node
    if(temp==NULL)
        return;
    while(temp->next!=NULL){
        if(temp->data == temp->next->data)
        {
            temp1=temp->next->next;
            free(temp->next);
            temp->next=temp1;
        }
        else{
            temp=temp->next;
        }   
    }


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
        cout<<"EMPTY!!";
        return;
    }
}

int main()
{
    Node *head = NULL;
    int ch;
    int result,result1;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Remove Duplicates";
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
        // Remove Duplicates
        case 2: 
        removeDuplicates(head);
        cout<<endl<<"Duplicates removed New Linked List->  "<<endl;
        display(head);
        cout<<endl;
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
    } while (ch != 4);
}