// Nth node from end


// Method 1
// using length of linked list

// Algorithm
// 1) Calculate the length of linked list
// 2) length/2
// 3) Iterate the linked list till the count == length/2

// Method 2
// Using Pointer


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
int countNodes(Node *head){
    int count=0;
    Node *temp=head;
    while(temp!=NULL){
        count ++;
        temp=temp->next;
    }
    return count;
} 


// Middle Element of the linked list Method 1
// Using Length of linked list
int nthNodeEndI(Node *head){
    int length = countNodes(head);
    Node *temp = head;
    int count =0;
    int resultNode = int(length/2);
    while(temp!=NULL){
        if (count == resultNode)
        {
            return temp->data;
        }
        count++;
        temp=temp->next;
    }
    return -1;
}

// Middle Element of the linked list Method 2
// Using pointers
int nthNodeEndII(Node *head){
    int count =0;
    Node *temp = head;
    Node *temp1 = head;
    while(temp1!=NULL)
    {
        // update temp when count is odd
        if(count & 1){
            temp=temp->next;
        }
         ++count;
        temp1=temp1->next;
    }
    if (temp!=NULL)
    return temp->data;
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
             << "2. Find Middle of Linked list Method 1";
        cout << endl
             << "3. Find Middle of Linked list Method 2";
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
        // Find the middle of linked list using method 1
        case 2:
            result=nthNodeEndI(head);
            if (result == -1){
                cout<<endl<<"element not found"<<endl;
            }
            else{
                cout<<"Value at given node: "<<result;
            }
            break;
        // Find the middle of linked list using method 2
        case 3:
            result1=nthNodeEndII(head);
            if (result1 == -1){
                cout<<endl<<"element not found"<<endl;
            }
            else{
                cout<<"Value at given node: "<<result1;
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