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

// Nth node of linked list
// Recursive
int nthNodeR(Node *head,int num){
    if (head==NULL)
        return -1;
    if (num==0)
        return head->data;
    return (nthNodeR(head->next,num-1));
}


// Iterative
int nthNodeI(Node *head){
    Node *temp=head;
    int num;
    cout<<endl<<"Enter the node number: ";
    cin>>num;
    num=num-1;
    int count = 0;
    while(temp!=NULL){
        if(count==num){
            return temp->data;
        }
        count++;
        temp=temp->next;
    }
    return -1;
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
    int ch,num;
    int result,result1;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Find Nth Node Recursively";
        cout << endl
             << "3. Find Nth Node Iteratively";
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
        // Find Nth Node Recursively function call
        case 2:
            cout<<endl<<"Enter the node number: ";
            cin>>num;
            result1=nthNodeR(head,(num-1));
            if (result1 == -1){
                cout<<endl<<"element not found"<<endl;
            }
            else{
                cout<<"Value at given node: "<<result1;
            }
            break;
        // Find Nth Node Iteratively
        case 3:
            result=nthNodeI(head);
            if (result == -1){
                cout<<endl<<"element not found"<<endl;
            }
            else{
                cout<<"Value at given node: "<<result;
            }
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