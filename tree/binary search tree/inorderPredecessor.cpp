// to find inorder predecessor of a given node
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
Node* Node:: inorderPredecessor(Node* root,int data){
    Node* temp = this->Node::search(root,data);
    if(!temp)
        return NULL;
    if(root->data)
        return minNodeR(temp->right);
    Node * successor = NULL;
    Node * ancestor = root;
    while(ancestor!=temp){
        if(temp->data < ancestor->data){
            successor = ancestor;
            ancestor = ancestor->left;
        }
        else
            ancestor = ancestor->left;
    }
    return ancestor;
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
    Node * ancestor = b.inorderPredecessor(root,25); 
    cout<<endl<<ancestor->data;

}


