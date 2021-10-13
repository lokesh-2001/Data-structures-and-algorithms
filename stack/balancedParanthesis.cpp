#include<bits/stdc++.h>
using namespace std;

void paranthesis(string st , int n){
    bool result= true;
    stack<char>s;
    for(int i=0;i<n;i++)
        if(st[i]=='(' || st[i]=='{'|| st[i]=='[')
            s.push(st[i]);
        else{
            if(!s.empty()){
                // check if top of stack is pair of current element
                char temp= s.top();
                s.pop();
                if(st[i]==')' && temp!='(')
                {
                    result=false;
                    break;
                }
                if(st[i]=='}' && temp!='{')
                {
                    result=false;
                    break;
                }
                if(st[i]==']' && temp!='[')
                {
                    result=false;
                    break;
                }
            }
            // stack empty
            else{
                result= false;
                break;
            }
        }
    
// if stack not empty after the loop then not balanced
if(!s.empty())
    result = false;
if(result)
    cout<<"balanced"<<endl;
else
    cout<<"Not balanced"<<endl;
}
int main(){
    string s="(){}[]";
    int n=s.length();
    paranthesis(s,n);
    return 0;
}