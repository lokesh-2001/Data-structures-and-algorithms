#include<bits/stdc++.h>
using namespace std;

// to check if a character is operand or not
bool operand(char c){
    return c>='0' && c<='9';
}
int prefix(string s){
    stack<int> st;
    for(int i=s.length()-1;i>=0;--i){
        if(operand(s[i]))
            st.push(s[i] - '0');
        else{
            int n1= st.top();
            st.pop();
            int n2= st.top();
            st.pop();
            switch(s[i]){
                case '*': st.push(n1*n2); break;
                case '+': st.push(n1+n2); break;
                case '-': st.push(n1-n2); break;
                case '/': st.push(n1/n2); break;
            }

        }
    }
    return st.top();
}
int main(){
    string s;
    cout<<"Enter prefix expression to evaluate: ";
    cin>>s;
    cout<<"Result: "<<prefix(s);
}
