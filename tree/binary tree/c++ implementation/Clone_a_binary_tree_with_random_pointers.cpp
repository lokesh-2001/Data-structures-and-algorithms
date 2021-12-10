// Given a Binary Tree where every node has the following structure. 

// struct node {  
//     int key; 
//     struct node *left,*right,*random;
// } 
// The random pointer points to any random node of the binary tree 
// and can even point to NULL, clone the given binary tree.

#include<bits/stdc++.h>
// #include<unordered_maps>
using namespace std;

struct Node{
    int key;
    struct Node* left, *right, *random;
};

Node *newNode(int key){
    Node* temp = new Node;
    temp->key = key;
    temp->random = temp->left = temp->right = NULL;
    return temp;
}   

// using unordered maps

// function to create the clone bu copying key, left and right pointers
// function also stores mapping from given tree node to clone
Node *copyLRNode(Node *root,unordered_map<Node *, Node* > &unmap){
    if(!root)
        return NULL;
    Node* cloneNode = newNode(root->key);
    unmap[root] = cloneNode;
    cloneNode->left = copyLRNode(root->left,unmap);
    cloneNode->right = copyLRNode(root->right,unmap);
    return cloneNode;
}   

// this function copies random node by using hasmap
void copyRan(Node* node, Node*cloneNode,unordered_map<Node *, Node *> &unmap){
    if(!cloneNode)
        return;
    cloneNode->random = unmap[node->random];
    copyRan(node->left,cloneNode->left,unmap);
    copyRan(node->right,cloneNode->right,unmap);
}

// makes the clone of a given tree
Node *cloneTree(Node *root){
    if(!root)
        return NULL;
    unordered_map<Node *,Node *>unmap;
    Node *newTree = copyLRNode(root,unmap);
    copyRan(root,newTree,unmap);
    return newTree;
}

void inorder(Node *root){
    if(!root)
        return;
    inorder(root->left);
    cout<<endl<<"[ "<<root->key<<"<->";
    if(root->random)
        cout<<root->random->key;
    else
        cout<<"NULL";

    cout<<" ]"; 
    inorder(root->right);  
}

int main(){
    Node *root =  newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->random = root->left->right;
    root->left->left->random = root;
    root->left->right->random = root->right;
    cout<<endl<<"Inorder Traversal for basic node: "<<endl;
    inorder(root);
    Node *cloneNode= cloneTree(root);
    cout<<endl<<"Inorder Traversal for Clone node: "<<endl;
    inorder(root);


}
