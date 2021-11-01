// problem-
// suppose there is a circle there are n petrol pumps on that circle
// given data
// the amount of petrol that every petrol pump has
// distance from that petrol pump to the next petrol pump
// calculate the first point from where a truck will be able to complete the circle
// 1 litre petrol 1 unit of distance

#include <bits/stdc++.h>
using namespace std;
class PetrolPump
{
public:
    int petrol;
    int distance;
};

int tour(PetrolPump arr[], int n)
{

    int start;
    for (int i = 0; i < n; i++)
    {
        // identify the 1st petrol pump from where we get a full circular tour
        if (arr[i].petrol >= arr[i].distance)
        {
            start = i;
            break;
        }
    }
    int curr_pet = 0; // excess petrol
    for (int i = start; i < n;)
    {
        curr_pet += (arr[i].petrol - arr[i].distance);
        // if at any point curr_pet < 0
        // journey cannot be started from current start
        if (curr_pet < 0)
        {
            i++; // move to next station
            // again find the next petrol pump
            for (; i < n; i++)
            {
                if (arr[i].petrol >= arr[i].distance)
                {
                    start = i;
                    curr_pet = 0;
                    break;
                }
            }
        }
        else{
            // move to next petrol pump 
            i++;
        }
    }
    // if remaining petrol is less than 0 while we reach the 1st petrol puml
    // no circular tour possible
    if(curr_pet < 0){
        return -1;
    }
    for(int j=0;j<start;j++){
        curr_pet += (arr[j].petrol - arr[j].distance);
        if(curr_pet < 0){
            return -1;
        }
    }

    return start;
}

int main(){
    PetrolPump arr[]= {{4,6},{6,5},{7,3},{4,5}};
    int n = sizeof(arr)/sizeof(arr[0]);
    int start = tour(arr,n);
    (start == -1) ? cout<<"No Solution" : cout<<"Start = "<<start+1<<"petrol pump";
}

