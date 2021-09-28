// Loop detection method 4

// Marking visited nodes without modifying the linked list ds
// int this method a temporary node is created. the next pointer of each node that is traversed
// is made to point to this temproray node. this way we are using the next pointer of a node as a flag
// to indicate whether the node has been traversed or not. every node is checked to see if the next is pointing to 
// a temp node or not. in this case of the first node of the loop, the second time we traverse it this condition will be true
// hence we find the loop exists
// if we come across a node that points to null then the loop doesn't exist

#include<bits/stdc++.h>
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


void displayLoop(Node *head, int num){
    cout<<endl<<"Linked List is: "<<endl;
    int count = 0;
    Node *temp=head,*temp1;
    // to find the particular node
    // if found store it in temp1 
    // and if temp1== temp i.e. the last node of loop print the data and exit
    // else continue the iteration and print the items
    cout<<temp->data;
    temp=temp->next;
    while(temp!=NULL){
        if(count==num)
            temp1=temp;
        if(temp1==temp){
            cout<<"->"<<temp->data<<"->"<<temp->next->data<<"->"<<temp->next->next->data;
            return;
        }
        cout<<"->"<<temp->data;
        count++;
        temp=temp->next;
    }
}

// Loop Insertion function (basically to insert a loop)
// input the node num to create a loop (link the last of the simple linked list to 
// the element present at the the given node number say num)
// Traverse the linked list till that node number and store it in a pointer say temp
// traverse to reach the end of linked list
// set the next of the last of the linked list to the node temp
// break

void insertLoop(Node *head, int num){
    int count = 0;
    Node *temp=head;
    Node *temp1;
    // to find the particular node
    // if found store it in temp1 break the loop
    while(temp!=NULL){
        if(count==num){
            // cout<<"1"<<endl;
            temp1=temp;
            break;
        }
        
        count++;
        temp=temp->next;
    }
    // cout<<"2"<<endl;
    // cout<<"temp1 value"<<temp1->data<<endl;
    if(temp1==NULL)
    {
        cout<<"Element not found";
        // cout<<"3"<<endl;
        return;
    }
    // cout<<"4"<<endl;
    temp=head;
    // to reach end of linked list
    // cout<<"head node: "<<temp->data<<endl;
  
    while(temp->next!=NULL)
        temp=temp->next;
    // cout<<"5"<<endl;
    // cout<<"end node: "<<temp->data<<endl;
    // set the next of last node to the temp1
    temp->next=temp1;
    cout<<"Calling display loop function"<<endl;
    displayLoop(head,num);

}


// display linked list without loop function 
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


bool detectLoop(Node *head){
    Node *temp = new Node;
    while(head!=NULL){
        // condition for no loop
        if(head->next== NULL)
            return false;
        // if node already pointing to temp
        if(head->next==temp)
        return true;
        // store the pointer to the next node in order to get to it in the next step
        Node * nex = head->next;
        // make next point to temp
        head->next=temp;
        // get to the next node in the list
        head=nex;
    }
    return false;

}

// Complexity Analysis:  

// Time complexity: O(n). 
// Only one traversal of the loop is needed.
// Auxiliary Space:O(1). 
// There is no space required.

int main()
{
    Node *head = NULL;
    int ch,num;
    bool loop;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout << endl
             << "2. Insert a Loop in linked list";
        cout << endl
             << "3. Display linked list with loop";
        cout << endl
             << "4. Display";
        cout << endl
             << "5. Detect Loop Using Method 4";
        cout << endl
             << "6. End";
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
        // Insert Loop Function 
        case 2:
            cout<<"Enter the loop index number: ";
            cin>>num;
            insertLoop(head,num);
            break;
        // Display Loop function
        case 3:
            
            break;
        // display function call
        case 4:
            display(head);
            break;
        case 5: 
            loop= detectLoop(head);
            if(loop)
                cout<<"Loop Detected!!";
            else
                cout<<"No Loop detected";
            break;
        case 6:
            cout << "INVALID CHOICE";
            break;
        default:
            cout << "INVALID CHOICE";
            break;
        }
    } while (ch != 6);
}








