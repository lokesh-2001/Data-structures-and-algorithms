// convert a binary tree to a circular linked list
#include<bits/stdc++.h>
using namespace std;
struct Node{
    struct Node*left, *right;
    int data;
};

// function to append right list  at the end of left list
Node * concatenate(Node *leftList, Node*rightList){
    // if either of the list is empty then return the other list
 if (leftList == NULL)
        return rightList;
    if (rightList == NULL)
        return leftList;
  
    // Store the last Node of left List
    Node *leftLast = leftList->left;
    Node *rightLast = rightList->left;
    leftLast->right = rightList;
    rightList->left = leftLast;
    leftList->left = rightLast;
    rightLast->right = leftList;
  
    return leftList;
}

// function converts a tree to a circular linked list
Node *convert(Node *root){
    if(!root)
        return NULL;
    Node *left =convert(root->left);
    Node *right =convert(root->right);
    root->left = root->right = root;
    return(concatenate(concatenate(left,root),right));
}
void displayCList(Node *head)
{
    cout << "Circular Linked List is :\n";
    Node *itr = head;
    do
    {
        cout << itr->data <<" ";
        itr = itr->right;
    } while (head!=itr);
    cout << "\n";
}
Node *newNode(int data)
{
    Node *temp = new Node();
    temp->data = data;
    temp->left = temp->right = NULL;
    return temp;
}
  
// Driver Program to test above function
int main()
{
    Node *root = newNode(10);
    root->left = newNode(12);
    root->right = newNode(15);
    root->left->left = newNode(25);
    root->left->right = newNode(30);
    root->right->left = newNode(36);
  
    Node *head = convert(root);
    displayCList(head);
  
    return 0;
}
