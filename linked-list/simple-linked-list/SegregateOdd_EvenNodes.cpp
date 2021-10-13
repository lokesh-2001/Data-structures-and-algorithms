// function to modify linked list such that
// all even numbers appear before all the odd numbers in modified ll

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

void SegregateOddAndEven(Node **head){
    Node *end = *head;
    Node *prev = NULL;
    Node *curr = *head;
    
    // get last node 
    while (end->next != NULL)
        end = end->next;
 
    Node *new_end = end;
 
    // loop till first even node or till end of linked list
    while (curr->data % 2 != 0 && curr != end)
    {
        new_end->next = curr;
        curr = curr->next;
        new_end->next->next = NULL;
        new_end = new_end->next;
    }
 
    // for even nodes 
    if (curr->data%2 == 0)
    {
        *head = curr;
        while (curr != end)
        {
            if ( (curr->data) % 2 == 0 )
            {
                prev = curr;
                curr = curr->next;
            }
            else
            {
                // break the link b/w prev and current
                prev->next = curr->next;
                // make next of current NULL
                curr->next = NULL;
                // Move curr to end 
                new_end->next = curr;
                //  make curr as new end of list 
                new_end = curr;
                curr = prev->next;
            }
        }
    }
 
    // set prev to current 
    else prev = curr;

    // if there are more than 1 odd nodes and end of original list is odd
    // then move this node to end to maintain the order of insertion in linked list
    if (new_end != end && (end->data) % 2 != 0)
    {
        prev->next = end->next;
        end->next = NULL;
        new_end->next = end;
    }
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
             << "2. Segregate Linked list in odd and even nodes";
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
        // Segregate even and odd nodes
        case 2:
            cout << "Old Linked list: " << endl;
            display(head);
            SegregateOddAndEven(&head);
            cout << endl
                 << "Segregation of odd and even nodes done" << endl;
            cout << "New Linked list: " << endl;
            display(head);
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


