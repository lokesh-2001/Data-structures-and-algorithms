// find th maximum width of a given binary tree
// using level order travesal and a queue
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

int width(Node *root){
    if(!root)
        return 0;
    int result =0;
    queue<Node * > q;
    q.push(root);
    while(!q.empty()){
        int count = q.size();
        result = max(count,result);
        while(count--){
            Node * temp = q.front();
            q.pop();
            if(temp->left)
                q.push(temp->left);
            if(temp->right)
                q.push(temp->right);

        }  
    }
    return result;
}
int main(){
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

    cout<<endl<<"Maximum Width: "<<width(root)<<endl;
}