#include<bits/stdc++.h>
using namespace std;
class Hash{
    int bucket;
    list<int> *table;
    public:
    Hash(int v){
        this->bucket = v;
        table =  new list<int>[bucket]; 
    }
    int hashFunc(int x){
        return (x%bucket);
    }
    void insert(int x){
        int index = hashFunc(x);
        table[index].push_back(x);
    }
    void deleteItem(int x){
        int index = hashFunc(x);
        list<int>  :: iterator i;
        for(i=table[index].begin(); i!=table[index].end(); i++){
            if(*i == x)
                break;
        }       
        if(i!=table[index].end())
            table[index].erase(i);
    }
    void display(){
        for(int i=0;i<bucket;i++){
            cout<<i;
            for(auto x:table[i])
                cout<<"-->"<<x;
            cout<<endl;
        }
    }

};
int main()
{
    int a[] = {15,11,27,8,12};
    int  n = sizeof(a)/sizeof(a[0]);
    Hash h(7);
    for(int i=0;i<n;i++)
        h.insert(a[i]);
    h.display();
    cout<<endl<<endl;
    h.deleteItem(12);
    cout<<endl<<endl;
    cout<<"after deletion: "<<endl;
    h.display();

    return 0;
}
