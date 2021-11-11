// Given two binary trees, check if the first tree is subtree of the second one. 
// A subtree of a tree T is a tree S consisting of a node in T and all of its 
// descendants in T. The subtree corresponding to the root node is the entire tree; 
// the subtree corresponding to any other node is called a proper subtree.

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

bool areIdentical(Node *root1,Node*root2){
    if(root1 == NULL && root2 == NULL)
        return true;
    if(root1 == NULL || root2 == NULL)
        return true;
    return( root1->data == root2->data &&
    areIdentical(root1->left,root2->left)&&
    areIdentical(root1->right,root2->right)
    );
}

bool isSubtree(Node *root1, Node*root2){
    if(!root2)
        return true;
    if(!root1)
        return false;
    
    if(areIdentical(root1,root2))
        return true;
    return (
        isSubtree(root1->left,root2) || 
        isSubtree(root1->right,root2)  
    );
    
}

int main(){
        //                  52
        //          25               96
        //      41      20      78      23
        //    36  48   49 67   76 84   19 12

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

    Node *root1 =  newNode(20);
    root1->left = newNode(49);
    root1->right = newNode(67);

    if(isSubtree(root,root1))
        cout<<"Yes Subset"<<endl;
   
    else
        cout<<"Not Subset"<<endl;

}

