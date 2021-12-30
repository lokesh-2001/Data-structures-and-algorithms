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
        bool isBSTUtil(Node *,int,int);
        bool isBST(Node *);
};
// isBSTUtil(Node *root,int minValue int maxValue
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

bool Node :: isBSTUtil(Node *root,int minValue, int maxValue){
    if(!root)
        return true;
    if( root->data > minValue && root->data < maxValue
        && isBSTUtil(root->left,minValue,root->data) && isBSTUtil(root->right,root->data,maxValue)
    )
    return true;
    return false;
}

bool Node :: isBST(Node *root){
    return isBSTUtil(root,INT_MIN,INT_MAX);
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
    if(b.isBST(root))
        cout<<endl<<"True";
    else
        cout<<endl<<"false";
}


