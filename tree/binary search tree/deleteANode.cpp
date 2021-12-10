#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node *left,*right;
        Node();
        Node(int);
        Node * insert(Node *,int);
        Node * minNodeR(Node *);
        Node * deleteNode(Node *,int);
        void inorder(Node *);
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
Node* Node:: minNodeR(Node* temp){
    while(temp && temp->left){
        temp=temp->left;}
    return temp;
}
Node* Node:: deleteNode(Node *root, int data){
    if(!root)
        return root;
    if(data < root->data)
        root->left =   deleteNode(root->left,data);      
    else if(data > root->data)
        root->right =   deleteNode(root->right,data);      
    else{
        // if key is equal to root = data
        // case 1 no child
        if(root->left == NULL && root->right == NULL)
            return NULL;
        // case 2 single child
        else if (root->left == NULL){
            Node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL){
            Node *temp = root->left;
            free(root);
            return temp;
        }
        else{
        // node with two children
        // as the node has two children so the in-order successor 
        // of this particular node will be the minimum node in the
        // left sub-tree 
        Node *temp = this->Node::minNodeR(root->left);
        root->data = temp->data;
        root->right = deleteNode(root->left,temp->data);}
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
    //         23  36
    Node b,  *root = NULL;
    root = b.insert(root,52);
    b.insert(root,25);
    b.insert(root,41);
    b.insert(root,20);
    b.insert(root,36);
    b.insert(root,96);
    b.insert(root,85);
    b.insert(root,100);
    b.insert(root,23);
    cout<<endl<<"root: "<<root->data<<endl;
    b.inorder(root);
    
    root = b.deleteNode(root,96); 
    cout<<endl<<"new root after deleting 96: "<<root->data<<endl;
    b.inorder(root);
    
    root = b.deleteNode(root,41);
    cout<<endl<<"new root after deleting 41: "<<root->data<<endl;
    b.inorder(root);
    
    root = b.deleteNode(root,52);
    cout<<endl<<"new root after deleting 52: "<<root->data<<endl;
    b.inorder(root);

}


