// Loop detection method 5

// In this method, two pointers are created (first on always point towards head) and the last
// each time the last pointer moves we calculate the no of nodes bw two pointers 
// and check whether the current no of nodes > previous no of nodes if yes we proceed by moving last pointer
// else it means we've reached the end of loop  


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
    Node *temp= new Node;
    Node *start=head, *last = head;
    // no of nodes b/w current and start and last
    int curr_len=0;
    // no of nodes b/w previous first and last
    int prev_len= -1;
    while(curr_len > prev_len && last!=NULL){
        // set prev_len to current length then update the current length
        prev_len= curr_len;
        last=last->next;
    }
    if(last==NULL)
        return false;
    return true;
}

// Complexity Analysis:  

//  Complexity Analysis:  

// Time complexity: O(n^2)
// Auxiliary Space: O(1)

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

