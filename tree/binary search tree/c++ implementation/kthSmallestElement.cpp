#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        int lcount;
        Node *left,*right;
        Node();
        Node(int);
        Node * insert(Node *,int);
        void inorder(Node *);
        Node * kth(Node *,int);
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
    if(data > root->data){
        root->right = insert(root->right, data);
        root->lcount++;    
    }
    if(data < root->data)
        root->left = insert(root->left, data);
    return root;
}

Node* Node:: kth(Node *root, int k){
    if(!root)
        return NULL;
    int count = root->lcount + 1;
    if(k==lcount)
        return root;
    if(count>k)
        return kth(root->left, k)

    return kth(root->right,  k - count);

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
    // cout<<endl<<b.search(root,96);

}


