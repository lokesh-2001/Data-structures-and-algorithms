// print a binary tree in vertical order
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node*left,*right;
    Node(int x){
        data = x;
        left = right = NULL;
    }
};

// method 1 
// check the horizontal distance from root
// if they are same then they lie on same vertical line
// using unordered maps
void print(Node*root){
    if(!root)
        return;
    unordered_map<int, vector<int>> m;
    int hd = 0 ;
    // create queue to de level order traversal
    // every item of queue contains node and horizontal distance
    queue<pair<Node*, int>> q;
    q.push({root,hd});
    // mx and mn min and max distance from root
    int mn = 0, mx = 0;
    while(q.size()>0){
        pair<Node*, int> temp = q.front();
        q.pop();
        hd = temp.second;
        Node * node = temp.first;
        m[hd].push_back(node->data);
        if(node->left)
            q.push({node->left,hd-1});
        if(node->right)
            q.push({node->right,hd+1});
           
        if(mn>hd)
            mn = hd;
        else if(mx<hd)
            mx = hd; 
    }
    for (int i=mn ;i <=mx;i++){
        vector<int> temp = m[i];
        for(int j = 0;j<temp.size();j++)
            cout<<temp[j]<<" ";
        cout<<endl;
    }

}

int main()
{
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->right = new Node(7);
    root->right->left->right = new Node(8);
    root->right->right->right = new Node(9);
    root->right->right->left = new Node(10);
    root->right->right->left->right = new Node(11);
    root->right->right->left->right->right = new Node(12);
    cout << "Vertical order traversal is \n";
    print(root);
    return 0;
}