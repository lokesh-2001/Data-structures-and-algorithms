// problem- 
// given traversals construct a binary tree
// the only cases which are possible are (one of the traversals must be inorder)
    // inorder & pre-order
    // inorder & post-order
    // inorder & level-order

// for inorder and preorder traversals
#include<bits/stdc++.h>
using namespace std;

struct Node{
    char data;
    struct Node*left;
    struct Node*right;
};
Node *newNode(char key){
    Node * temp = new Node;
    temp->data = key;
    temp->left = temp->right = NULL;
    return temp;
}
// https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

// Node *build(char in[],char pre[])


// using hashing