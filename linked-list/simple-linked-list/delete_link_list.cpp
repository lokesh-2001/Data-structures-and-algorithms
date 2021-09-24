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

// Delete Linked List
void deleteLinkList(Node **head)
{
    Node *temp;
    temp = (*head);
    Node *temp1 = NULL;
    while (temp != NULL)
    {
        temp1 = temp->next;
        cout << endl
             << "THE FIRST NODE DELETED HAVING VALUE " << temp->data << endl;
        free(temp);
        temp = temp1;
    }
    *head=NULL;
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
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Delete";
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
        // delete function call
        case 2:
            int deletechoice;
            do
            {
                cout << endl<< "1. DELETE LINKED LIST";
                cout << endl<< "2. EXIT";
                cout << endl
                     << "Enter choice: ";
                cin >> deletechoice;
                switch (deletechoice)
                {
                case 1:
                    deleteLinkList(&head);
                    break;
                case 2:
                    cout << endl
                         << "EXIT DELETE FUNCTION" << endl;
                    break;
                default:
                    break;
                }
            } while (deletechoice != 2);
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