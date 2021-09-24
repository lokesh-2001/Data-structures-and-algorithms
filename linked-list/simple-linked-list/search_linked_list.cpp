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

// Search an element
// Recursive
bool searchR(Node *head,int num){
    if(head==NULL)
        return false;
    if(head->data==num){
        return true;
    }
    return searchR(head->next,num);
}


// Iterative
bool searchI(Node *head){
    // bool test= false;
    Node *temp=head;
    int num;
    cout<<"Enter the value to be searched: ";
    cin>>num;

    while(temp!=NULL){
        if(temp->data==num){
            return true;
        }
        temp=temp->next;
    }
    return false;
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
    bool result,result1;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Search Recursively";
        cout << endl
             << "3. Search Iteratively";
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
        // Search Recursively function call
        case 2:
            cout<<"Enter the value to be searched: ";
            cin>>num;
            result1 = false;
            result1= searchR(head,num);
            if (result1){
                cout<<"PRESENT"<<endl;
            }
            else{
                cout<<"NOT PRESENT"<<endl;
            }
            break;
        // Search Iteratively
        case 3:
            result = false;
            result= searchI(head);
            if (result){
                cout<<"PRESENT"<<endl;
            }
            else{
                cout<<"NOT PRESENT"<<endl;
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