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
bool ancestors(Node *root, int targetNode){
    if(!root)
        return false;
    if(root->data == targetNode)
        return true;
    if(ancestors(root->left,targetNode) || ancestors(root->right,targetNode)){
        cout<<root->data<<" ";
        return true;
    }
    return false;
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

    ancestors(root,36);
}