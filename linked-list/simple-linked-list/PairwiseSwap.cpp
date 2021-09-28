// Swap elements of linked list pair wise
// swap data of pair
// E.g.
// Input: 1->2->3->4->5
// Output: 2->1>4->3->5

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
// Method 1 Iteratively
void swapNodesPairwiseI(Node **head)
{
    cout << "Old Linked list: " << endl;
    display(*head);
    Node *temp = *head;
    int x;
    while (temp != NULL && temp->next != NULL)
    {
        // swap temp->next and temp data
        x = temp->data;
        temp->data = temp->next->data;
        temp->next->data = x;

        temp = temp->next->next;
    }

    cout << endl
         << "PairWise Node Swapped" << endl;
    cout << "New Linked list: " << endl;
    display(*head);
}
// Time complexity O(n)

// Method 2 Recursively
void swapNodesPairwiseR(Node *head)
{
    int x;
    if (head != NULL && head->next != NULL)
    {
        // swap temp->next and temp data
        x = head->data;
        head->data = head->next->data;
        head->next->data = x;

        // call function Recursively
        swapNodesPairwiseR(head->next->next);
    }
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
             << "2. Swap Pairwise Nodes Iteratively";
        cout << endl
             << "3. Swap Pairwise Nodes Recursively";
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
        // swap nodes method 1
        case 2:
            swapNodesPairwiseI(&head);
            break;
        // Swap Nodes method 2
        case 3:
            cout << "Old Linked list: " << endl;
            display(head);
            swapNodesPairwiseR(head);
            cout << endl
                 << "PairWise Node Swapped" << endl;
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
