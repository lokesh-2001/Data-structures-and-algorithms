// lowest common ancestor of two nodes will be the lowest depth value node for 
// which lies between n1 and n2, n1 < n2
// if nodes value is greater than both n1 and n2 them LCA lies in left
// if nodes value is less than both n1 and n2 them LCA lies in right
// else root is LCA

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
        Node * LCA(Node *,int,int);

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

Node* Node:: LCA(Node *root, int n1,int n2){
    while(root!=NULL){
        if(root->data > n1 && root->data>n2)
            root = root->left;
        else if(root->data < n1 && root->data < n2)
            root = root->right;
        else
        break;
    }
    return root;
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
    //         23  36   45
    Node b,  *root = NULL;
    root = b.insert(root,52);
    b.insert(root,25);
    b.insert(root,41);
    b.insert(root,20);
    b.insert(root,36);
    b.insert(root,96);
    // b.insert(root,45);
    b.insert(root,23);
    b.inorder(root);
    Node *temp = b.LCA(root,96,23);
    cout<<endl<<"LCA: "<<temp->data;
}


