// Check Palindrome  
// A simple solution is to use a stack of list nodes. This mainly involves three steps.
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

// Method 1
// Using Stack
// Traverse the given list from head to tail and push every visited node to stack.
// Traverse the list again. For every visited node, pop a node from the stack and compare data of 
    // popped node with the currently visited node.
// If all nodes matched, then return true, else false.

bool checkPalindromeStack(Node *head){
    Node *temp=head;
    stack <int> s;
    while(temp!=NULL)
    {
        s.push(temp->data);
        temp=temp->next;
    }
    // Iteration of linked list again
    temp=head;
    int top;
    while(temp!=NULL){
        top=s.top();
        s.pop();
        if(temp->data != top)
            return false;
    temp=temp->next;
    }
    
    return true;

}


// Method 2 
// Using Recursion

// Use two pointers left and right. Move right and left using recursion 
// and check for following in each recursive call. 
// 1) Sub-list is a palindrome. 
// 2) Value at current left and right are matching.
// If both above conditions are true then return true.
// The idea is to use function call stack as a container. Recursively traverse till the end of list. 
// When we return from last NULL, we will be at the last node. 
// The last node to be compared with first node of list.

// In order to access first node of list, we need list head to be available in the last call of recursion.
//  Hence, we pass head also to the recursive function. If they both match we need to compare (2, n-2) nodes. 
//  Again when recursion falls back to (n-2)nd node, we need reference to 2nd node from the head. We advance 
//  the head pointer in the previous call, to refer to the next node in the list.
// However, the trick is identifying a double-pointer. Passing a single pointer is as good as pass-by-value, 
// and we will pass the same pointer again and again. We need to pass the address of the head pointer for 
// reflecting the changes in parent recursive calls.

bool checkPalindromeRecursionUpper(Node **left, Node *right){
    // stop recursion when right becomes NULL
    if(right==NULL)
        return true;
    // if sub-list is not palindrome then no need to check for current left and right 
    // return false
    bool isp=checkPalindromeRecursionUpper(left,right->next);
    if(!isp)
        return false;
    bool isp1 = (right->data == (*left)->data);
    *left = (*left) -> next;
    return isp1;
}

bool checkPalindromeRecursion(Node *head){
    checkPalindromeRecursionUpper(&head,head);
}


// Method 3
// By reversing the list
//  1) get the middle of the linked list
//  2) Reverse the second half of the linked list
//  3) Check if the first half and second half are identical
//  4) Construct the original linked list by reversing the second half again and attaching it back to the first half
void reverse(Node **head){
    Node *prev=NULL;
    Node *current = *head;
    Node *next;
    while(current!=NULL){
        next=current->next;
        current->next=prev;
        prev = current;
        current=next;
    }
    *head=prev;
}
bool compareList(Node *head1,Node *head2)
{
    Node *temp1 =head1,*temp2=head2;
    while(temp1&&temp2){
        if(temp1->data==temp2->data)
        {
            temp1=temp1->next;
            temp2=temp2->next;
        }
        else
        return false;
    }
    if(temp1==NULL && temp2==NULL)
        return true;
    
    return false;
}


bool checkPalindromeReverse(Node *head){
    struct Node *slow_ptr = head, *fast_ptr = head;
    struct Node *second_half, *prev_of_slow_ptr = head;
     
    // To handle odd size list
    struct Node* midnode = NULL;
     
    // initialize result
    bool res = true;
 
    if (head != NULL && head->next != NULL)
    {
         
        // Get the middle of the list. Move slow_ptr by 1
        // and fast_ptrr by 2, slow_ptr will have the middle
        // node
        while (fast_ptr != NULL && fast_ptr->next != NULL)
        {
            fast_ptr = fast_ptr->next->next;
 
            // We need previous of the slow_ptr for
            // linked lists with odd elements
            prev_of_slow_ptr = slow_ptr;
            slow_ptr = slow_ptr->next;
        }
 
        // fast_ptr would become NULL when there
        // are even elements in list. And not NULL
        // for odd elements. We need to skip the
        // middle node for odd case and store it
        // somewhere so that we can restore the
        // original list
        if (fast_ptr != NULL)
        {
            midnode = slow_ptr;
            slow_ptr = slow_ptr->next;
        }
 
        // Now reverse the second half and
        // compare it with first half
        second_half = slow_ptr;
         
        // NULL terminate first half
        prev_of_slow_ptr->next = NULL;
         
        // Reverse the second half
        reverse(&second_half);
         
        // compare
        res = compareList(head, second_half);
 
        // Construct the original list back
        reverse(&second_half); // Reverse the second half again
 
        // If there was a mid node (odd size case)
        // which was not part of either first half
        // or second half.
        if (midnode != NULL)
        {
            prev_of_slow_ptr->next = midnode;
            midnode->next = second_half;
        }
        else
            prev_of_slow_ptr->next = second_half;
    }
    return res;

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
    bool palindrome;
    system("cls");
    do
    {
        cout << endl
             << "1. Insert";
        cout<<endl<<"2. Check Palindrome Using Stack";
        cout<<endl<<"3. Check Palindrome Using Recursion";
        cout<<endl<<"4. Check Palindrome Using Reverse Function";
        cout << endl
             << "5. Display";
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
        case 2:
            cout<<endl<<"Calling check Palindrome using recursion using stack"<<endl; 
            palindrome = checkPalindromeStack(head);
            if (palindrome)
                cout<<"Palindrome Exists";
            else
                cout<<"Palindrome Not Exists";
            break;
        case 3:
        cout<<endl<<"Calling check Palindrome using recursion using recursion"<<endl; 
         checkPalindromeRecursion(head) ? cout<<"Is Palindrome"<<endl : cout<<"Not Palindrome";
         break;
        case 4:
            cout<<endl<<"Calling check Palindrome using reverse function"<<endl; 
            palindrome = checkPalindromeReverse(head);
            if (palindrome)
                cout<<"Palindrome Exists";
            else
                cout<<"Palindrome Not Exists";
            break;
        case 5:
            display(head);
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