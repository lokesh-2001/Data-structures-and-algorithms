#include<bits/stdc++.h>
using namespace std;
// sort the stack using temp stack. loop the main stack until the underflow
// condition occurs. then pop the element of temp stack and compare it with 
// element in the temp stack. if top of temp is > popped element of main pop 
// it out of temp stack and push it into main stack and push the popped element of
// main into temp

// at the end the main stack gets empty and elements are stored in the temp stack
// in descreasing sorted order. if we want the the order to be increasing
// push all elements back to main stack

stack<int> sort(stack<int> &mainStack){
    stack<int> auxStack;
    while(!mainStack.empty()){
        int temp = mainStack.top();
        mainStack.pop();
        while(!auxStack.empty() && auxStack.top()>temp)
        {
            mainStack.push(auxStack.top());
            auxStack.pop();
        }
        auxStack.push(temp);
    }
    return auxStack;
}
int main(){
    stack<int> mainStack; 
  mainStack.push(78); 
  mainStack.push(103); 
  mainStack.push(31); 
  mainStack.push(19); 
  mainStack.push(67); 
  mainStack.push(83); 
  mainStack.push(47);
  stack<int> AuxStack = sort(mainStack); 
  cout << "Sorted numbers in decreasing order are:"<<endl; 
  while (!AuxStack.empty()) 
  { 
    cout << AuxStack.top()<< " "; 
    mainStack.push(AuxStack.top());
    AuxStack.pop(); 
  } 
  cout<<endl;
  cout<<"Sorted numbers in increasing order are:"<<endl;
  while(!mainStack.empty()){
      cout<<mainStack.top()<<" ";
      mainStack.pop();
  }

}