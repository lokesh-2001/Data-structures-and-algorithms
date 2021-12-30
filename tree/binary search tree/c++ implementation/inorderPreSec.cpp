// to find inorder predecessor and successor
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
        Node * minNodeR(Node *);
        Node * inorderPredecessor(Node *,int);
        Node * inorderSuccessor(Node *,int);
        Node *  search(Node *,int);
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

Node* Node ::  search(Node *root, int data){
    if(root->data == data)
        return root;
    if(root->data < data)
        return search(root->right,data);
    return search(root->left,data);
}

Node* Node:: minNodeR(Node* temp){
    while(temp && temp->left){
        temp=temp->left;}
    return temp;
}
void Node:: inorder(Node *root){
    if(!root)
        return;
    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);
}
// minimum value in left subtree
Node* Node:: inorderSuccessor(Node* root,int data){
    if(!root)
        return NULL;
    if(root->data == data  && root->left !=NULL){
        Node * temp = root->right;
        while(temp->left)
            temp=temp->left;
        return temp;
    }
    // if(root->data > data)
        
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
    Node * ancestor = b.inorderSuccessor(root,25); 
    cout<<endl<<ancestor->data;

}
