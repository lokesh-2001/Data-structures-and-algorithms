// count the number of times a given int occurs in a Linked List

// Method 1 Iterative
// Method 2 Recursive


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


// Method 1
// Iterative
int countItemI(Node *head){
    int length = countNodes(head);
    Node *temp = head;
    int count =0;
    int num;
    cout<<"Enter the element which needs to be counted: ";
    cin>>num;
    while(temp!=NULL){
        if(temp->data==num)
        {
            count++;
        }
        temp=temp->next;
    }
    return count;
}
// Time complexity O(n)
// Auxiliary Space O(1)


// Method 2
// Recursive
int countForR=0;
int countItemR(Node *head,int num){
    if(head==NULL)
    {
        return countForR;
    }
    if(head->data==num)
    {
        countForR++;
    }
    if(countForR == 0 )
        return 0;
    return countItemR(head->next,num);

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
             << "2. Count a given Element Method 1 Iterative";
        cout << endl
             << "3. Count a given Element Method 2 Recursive";
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
        // Count a given Element Method 1 Iterative
        case 2:
            result=countItemI(head);
            if (result == 0){
                cout<<endl<<"element not Present"<<endl;
            }
            else{
                cout<<"Item Present : "<<result<<" times";
            }
            break;
        // Count a given Element Method 2 Recursive
        case 3:
            cout<<"Enter the element to which needs to be counted: ";
            cin>>num;
            result=countItemR(head,num);
            if (result == 0){
                cout<<endl<<"element not Present"<<endl;
            }
            else{
                cout<<"Item Present : "<<result<<" times";
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


