#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node *left,*right;
        Node();
        Node(int);
        Node * insert(Node *,int);
        void inorder(Node *);
        int search(Node *,int);
};
Node :: Node()
    :data(0) 
    ,left(NULL)
    ,right(NULL)
{
}
Node :: Node(int x){
    data  = x ;
    left  = NULL ;
    right = NULL ;
}

Node* Node::insert(Node *root,int data){
    if(!root)
        return new Node(data);
    if(data > root->data)
        root->right = insert(root->right, data);
    if(data < root->data)
        root->left = insert(root->left, data);
    return root;
}

int Node:: search(Node *root, int data){
    if(root->data == data)
        return root->data;
    if(root->data < data)
        return search(root->right,data);
    return search(root->left,data);
}
void Node:: inorder(Node *root){
    if(!root)
        return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}



int main(){
    // BST
    //               52
    //           25      96
    //       20      41
    //         23  36
    Node b,  *root = NULL;
    root = b.insert(root,52);
    b.insert(root,25);
    b.insert(root,41);
    b.insert(root,20);
    b.insert(root,36);
    b.insert(root,96);
    b.insert(root,23);
    b.inorder(root);
    cout<<endl<<b.search(root,96);

}


