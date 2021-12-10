// connect nodes at same level
#include<bits/stdc++.h>
using namespace std;
struct Node{
    int data;
    struct Node *left;
    struct Node *right;
    struct Node *next;
};

Node *newNode(char key){
    Node * temp = new Node;
    temp->data = key;
    temp->left = temp->right = temp->next = NULL;
    return temp;
}
void connect(Node *root){
    if(!root)
        return;
    queue<Node * > q;
    q.push(root);
    while(!q.empty()){
        int count = q.size();
        Node *prev = NULL;
        while(count--){
            Node * temp = q.front();
            q.pop();
            if(temp->left)
                q.push(temp->left);
            if(temp->right)
                q.push(temp->right);
            if(prev)
                prev->next = temp;
            prev=temp;
        }  
            prev->next = NULL;
    }
}


int main(){
        //                  52
        //          25               96
        //      41      20      78      23

    Node *root =  newNode(52);
    root->left = newNode(25);
    root->left->left = newNode(41);
    root->left->right = newNode(20);

    root->right = newNode(96);
    root->right->right = newNode(23);
    root->right->left = newNode(78);
    cout<<"Next of "<<root->data<<" :"<<(root->next ? root->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->data<<" :"<<(root->left->next ? root->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->data<<" :"<<(root->right->next ? root->right->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->left->data<<" :"<<(root->left->left->next ? root->left->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->right->data<<" :"<<(root->left->right->next ? root->left->right->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->left->data<<" :"<<(root->right->left->next ? root->right->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->right->data<<" :"<<(root->right->right->next ? root->right->right->next->data : -1)<<endl;
    connect(root);
    cout<<endl<<endl<<"After Connecting"<<endl<<endl;
    cout<<"Next of "<<root->data<<" :"<<(root->next ? root->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->data<<" :"<<(root->left->next ? root->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->data<<" :"<<(root->right->next ? root->right->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->left->data<<" :"<<(root->left->left->next ? root->left->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->left->right->data<<" :"<<(root->left->right->next ? root->left->right->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->left->data<<" :"<<(root->right->left->next ? root->right->left->next->data : -1)<<endl;
    cout<<"Next of "<<root->right->right->data<<" :"<<(root->right->right->next ? root->right->right->next->data : -1)<<endl;

}
