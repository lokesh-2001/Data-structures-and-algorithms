#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    int data;
    Node *left;
    Node *right;
};

Node *findmin(Node *root){
    if(root ==  NULL)
        return NULL;
    while(root->left!=NULL)
        root = root->left;
    return root;
}
Node *  search(Node *root, int data){
    if(root->data == data)
        return root;
    if(root->data < data)
        return search(root->right,data);
    return search(root->left,data);
}
Node* minNodeR(Node* root){
    if(!root->left)
        return root;
    minNodeR(root->left);
}
Node *getSuccessor(Node *root, int data){
    Node *temp = search(root,data);
    if(!temp) 
        return NULL;
    // case 1 node has a right subtree
    if(current->right)
        return minNodeR(temp->right);
    }  
    // case 2: no right subtree
    Node * successor = NULL;
    Node * ancestor = root;
    while(ancestor != temp){
        if(temp->data < ancestor->data){
            successor = ancestor;
            ancestor = ancestor->left;
        }
        else
            ancestor = ancestor->right;
    }
    return successor;
}