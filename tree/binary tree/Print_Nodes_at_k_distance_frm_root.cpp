#include<bits/stdc++.h>
using namespace std;
struct Node{
    int data;
    struct Node *left;
    struct Node *right;
};

Node *newNode(char key){
    Node * temp = new Node;
    temp->data = key;
    temp->left = temp->right = NULL;
    return temp;
}
void printNodes(Node *root, int k){
    if((!root) || k<0)
        return;
    if(k==0)
    {
        cout<<root->data<<" ";
        return;
    }
    printNodes(root->left,k-1);
    printNodes(root->right,k-1);
}
int main(){
    Node *root =  newNode(52);
    root->left = newNode(25);
    root->left->left = newNode(41);
    root->left->right = newNode(20);

    root->left->left->left = newNode(36);
    root->left->left->right = newNode(48);

    root->left->right->left = newNode(49);
    root->left->right->right = newNode(67);
    root->right = newNode(96);
    root->right->right = newNode(23);
    root->right->left = newNode(78);

    root->right->right->right = newNode(12);
    root->right->right->left = newNode(19);

    root->right->left->left = newNode(76);
    root->right->left->right = newNode(84);

    printNodes(root,3);
}