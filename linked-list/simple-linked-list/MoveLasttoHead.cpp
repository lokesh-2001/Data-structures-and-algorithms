// Move last element to front
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
void LastToHead(Node **head){
    if(*head==NULL || (*head)->next==NULL)
        return;
    Node *last=*head,*temp=NULL;
    while(last->next!=NULL){
        // Second last element temp
        temp=last;
        // last element last 
        last=last->next;
    }
    temp->next=NULL;
    last->next=*head;
    *head=last;

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
             << "2. Move Last to front";
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
        case 2:
            cout << "Old Linked list: " << endl;
            display(head);
            LastToHead(&head);
            cout << endl
                 << "PairWise Node Swapped" << endl;
            cout << "New Linked list: " << endl;
            display(head);
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
