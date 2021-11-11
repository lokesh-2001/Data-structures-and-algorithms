#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    int data;
    Node *left;
    Node *right;
};
Node* createNode(int item){
    Node * node = new Node;
    node->data = item;
    node->left = node->right = NULL;
    return node; 
}
Node* insert(Node *root,int data){
    if(!root)
        return createNode(data);
    
    if(data < root->data)
        root->left = insert(root->left,data);
    else    
        root->right = insert(root->right,data);
    return root;
}
int search(Node *root, int data){
    if(root->data == data)
        return root->data;
    if(root->data < data)
        return search(root->right,data);
    return search(root->left,data);
}

int minNode(Node* root){
    Node * temp = root;
    while(temp->left!=NULL)
        temp = temp->left;
    return temp->data;  
}
int minNodeR(Node* root){
    if(!root->left)
        return root->data;
    minNodeR(root->left);
}
int maxNode(Node* root){
    Node * temp = root;
    while(temp->right!=NULL)
        temp = temp->right;
    return temp->data;  
}
int maxNodeR(Node* root){
    if(!root->right)
        return root->data;
    minNodeR(root->right);
}
