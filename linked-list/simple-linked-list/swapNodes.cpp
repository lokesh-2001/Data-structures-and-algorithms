// swap nodes for two given keys Node should be swapped by changing links
// Method 1 find x and y in 2 different loops
// Search x and y in given list
// if any one of them in not present, return
// while searching keep track of current and previous pointers
// first change next of previous then next of current pointers
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
        cout<<"EMPTY!!";
        return;
    }
}
void swapNodesI(Node **head){
    int num1,num2;
    // node 1
    cout<<endl<<"Enter the data of 2 nodes to be swapped";
    cout<<endl<<"Node 1-> ";
    cin>>num1;
    // node 2
    cout<<endl<<"Node 2-> ";
    cin>>num2;
    if(num1==num2)
        return;
    cout<<"Old Linked list: "<<endl;
    display(*head);
    // Node *temp=head;
    Node *node1X=NULL,*node2X=*head;
    //  *node1X for prev node for x
    //  *node2X for current node for x
    while(node2X && node2X->data !=num1){
        node1X=node2X;
        node2X=node2X->next;
    }
    Node *node1Y=NULL,*node2Y=*head;
    //  *node1Y for prev node for y
    //  *node2Y for current node for y
    while(node2Y && node2Y->data !=num2){
        node1Y=node2Y;
        node2Y=node2Y->next;
    }
    if (node2X==NULL || node2Y==NULL)
        return;
    // if x is not head of linked list
    if(node1X!=NULL)
    node1X->next=node2Y;
    
    else{
        // make y as head 
        *head=node2Y;
    }
    // if y is not head of linked list
    if(node1Y!=NULL)
    node1Y->next=node2X;
    
    else{
        // make x as head 
        *head=node2X;
    }
    Node *temp= node2Y->next;
    node2Y->next=node2X->next;
    node2X->next=temp;
    cout<<endl<<"Nodes Swapped"<<endl;
    cout<<"New Linked list: "<<endl;
    display(*head);

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
        cout<<endl<<"2. Swap Nodes";
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
        // Swap Nodes method 1
        case 2:
        swapNodesI(&head);
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

