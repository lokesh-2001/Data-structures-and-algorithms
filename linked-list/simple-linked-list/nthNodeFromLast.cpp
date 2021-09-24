// Nth node from end


// Method 1
// using length of linked list

// Algorithm
// 1) Calculate the length of linked list
// 2) Print the (len-n+1) node from beginning 

// Method 2
// Using two Pointers
// Maintain 2 pointers - refernce and main pointer. initialize both to head
// First move the refernce pointer to n nodes from head 
// now move both the pointers one by one until the reference pointer reached the end
// now the main pointer will point to nth node from end
// return the main pointer's data

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


// Nth node from end of the linked list Method 1
// Iterative 
int nthNodeEndI(Node *head){
    int length = countNodes(head);
    int num;
    Node *temp = head;
    int count =0;
    cout<<endl<<"Enter the node number from end: ";
    cin>>num;
    int resultNode = (length - num);
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
// Time Complexity- O(n) n is length of linked list 

// Nth node from end of the linked list Method 2
// Using two pointers
int nthNodeEndII(Node *head){
    Node *temp=head;  // reference pointer
    Node *temp1=head; // Main pointer
    int num;
    int count =0;
    cout<<endl<<"Enter the node number from end: ";
    cin>>num;
    while(temp!=NULL){
        if(count==num){
            break;
            // temp the refernce pointer reaches the n nodes from head 
        }
        count ++;
        temp=temp->next;
    }
    while(temp!=NULL){
        temp=temp->next;
        temp1=temp1->next;
    }
    return temp1->data;
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
             << "2. Find Nth Node from end Method 1";
        cout << endl
             << "3. Find Nth Node from end Method 2";
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
        // Find Nth Node from end Method 1
        case 2:
            result=nthNodeEndI(head);
            if (result == -1){
                cout<<endl<<"element not found"<<endl;
            }
            else{
                cout<<"Value at given node: "<<result;
            }
            break;
        // Find Nth Node from end Method 2
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