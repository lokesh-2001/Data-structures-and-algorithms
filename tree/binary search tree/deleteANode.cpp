#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    int data;
    Node *left;
    Node *right;
};
Node* minNodeR(Node* root){
    if(!root->left)
        return root;
    minNodeR(root->left);
}
// this function deletes the node with value equal to key and returns the new node
Node *deleteNode(Node* root, int key){
    if(!root)
        return root;
    if(key < root->data)
        root->left =   deleteNode(root->left,key);      
    if(key > root->data)
        root->right =   deleteNode(root->right,key);      
    else{
        // if key is equal to root = data
        // case 1 no child
        if(root->left == NULL && root->right == NULL)
            return NULL;
        // case 2 single child
        else if (root->left == NULL){
            Node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL){
            Node *temp = root->left;
            free(root);
            return temp;
        }
        // node with two children
        // as the node has two children so the in-order successor 
        // of this particular node will be the minimum node in the
        // right sub-tree 
        Node *temp = minNodeR(temp->right);
        root->key = temp->key;
        root->right = deleteNode(root->right,temp->key);
    }
    return root;
}