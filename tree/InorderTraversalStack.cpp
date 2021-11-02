#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    int data;
    Node *left;
    Node *right;
    Node( int x ){
        data = x;
        left = NULL;
        right = NULL;
    }
};

void inorder(Node *root){
    stack<Node*> s;
    Node *curr = root;
    while(!s.empty()|| curr != NULL){
        while(curr!=NULL){
            s.push(curr);
            curr = curr->left;
        }
        curr= s.top();
        cout<<curr->data<<" ";
        s.pop();
        curr= curr->right;
    }

}

int main(){
        //                  52
        //          25               96
        //      41      20      78      23
        //    36  48   49 67   76 84   19 12

    // Node *root =  new Node(52);
    // root->left = new Node(25);
    // root->left->left = new Node(41);
    // root->left->right = new Node(20);

    // root->left->left->left = new Node(36);
    // root->left->left->right = new Node(48);

    // root->left->right->left = new Node(49);
    // root->left->right->right = new Node(67);
    // root->right = new Node(96);
    // root->right->right = new Node(23);
    // root->right->left = new Node(78);

    // root->right->right->right = new Node(12);
    // root->right->right->left = new Node(19);

    // root->right->left->left = new Node(76);
    // root->right->left->right = new Node(84);

    Node *root =  new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    cout<<"Inorder traversal withour recursion: "<<endl;
    inorder(root);

}