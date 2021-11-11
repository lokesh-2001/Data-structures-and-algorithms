// BREADTH FIRST TRAVERSALS
// LEVEL ORDER TRAVERSAL
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

// function to return height of tree
int height(Node * node){
    if(node == NULL)
    return 0;
    int lHeight = height(node->left);
    int rHeight = height(node->right);
    if(lHeight > rHeight)
        return (lHeight + 1);
    else
        return (rHeight + 1);
}
// function to print nodes at current level
void CurrentLevel(Node * node,int level){
    if(node == NULL)
        return;
    if(level == 1)
        cout<<node->data<<" ";
    else if (level > 1){
        CurrentLevel(node->left,level-1);
        CurrentLevel(node->right,level-1);
    }
}

// function for level order traversal that uses currentLevel function
// to print all the nodes present at given level

void LevelOrder(Node *root){
    int h =height(root);
    for(int i=1;i<=h;i++)
        CurrentLevel(root,i);
}

int main(){
        //                  52
        //          25               96
        //      41      20      78      23
        //    36  48   49 67   76 84   19 12

    Node *root =  new Node(52);
    root->left = new Node(25);
    root->left->left = new Node(41);
    root->left->right = new Node(20);

    root->left->left->left = new Node(36);
    root->left->left->right = new Node(48);

    root->left->right->left = new Node(49);
    root->left->right->right = new Node(67);
    root->right = new Node(96);
    root->right->right = new Node(23);
    root->right->left = new Node(78);

    root->right->right->right = new Node(12);
    root->right->right->left = new Node(19);

    root->right->left->left = new Node(76);
    root->right->left->right = new Node(84);

    cout<<"Level Order Traversal: "<<endl;
    LevelOrder(root);
  

}