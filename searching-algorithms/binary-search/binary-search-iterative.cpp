#include<iostream>
#include<stdlib.h>
using namespace std;
bool checkSorted(int *arr, int n)
{
    int count=0;
    for(int i=0;i<n;i++){
        if(arr[i]>arr[i+1])
        {
            count ++;
        }
    }
    return count==0;
}
int binarySearch(int array[], int x, int low, int high){
    while(low<=high){
        int mid=low+(high-low)/2;
        if(array[mid]==x)
        return mid;
        else if (array[mid]<x){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return -1;
}
void merge(int a[],int i1,int j1,int i2,int j2)
{
    int temp[50];    //array used for merging
    int i,j,k;
    i=i1;    //beginning of the first list
    j=i2;    //beginning of the second list
    k=0;
    while(i<=j1 && j<=j2)    //while elements in both lists
    {
        if(a[i]<a[j])
            temp[k++]=a[i++];
        else
            temp[k++]=a[j++];
    }
    while(i<=j1)    //copy remaining elements of the first list
        temp[k++]=a[i++];
    while(j<=j2)    //copy remaining elements of the second list
        temp[k++]=a[j++];
    //Transfer elements from temp[] back to a[]
    for(i=i1,j=0;i<=j2;i++,j++)
        a[i]=temp[j];
}


void mergesort(int a[],int i,int j)
{
    int mid;
    if(i<j)
    {
        mid=(i+j)/2;
        mergesort(a,i,mid);        //left recursion
        mergesort(a,mid+1,j);    //right recursion
        merge(a,i,mid,mid+1,j);    //merging of two sorted sub-arrays
    }
}
void printArray(int array[], int n) 
{ 
    int i; 
    for (i = 0; i < n; i++) 
        cout<<(array[i])<<" "; 
    cout<<endl<<endl; 
}
int main()
{
    system("cls");
    int arr[100], n,x;
    // ask user for number of elements to be sorted
    cout<<("Enter the number of elements: ");
    cin>>n;
    // input elements if the array
    for(int i=0;i<n;i++)
    {
        cout<<("Enter element: ");
        cin>>arr[i];
    }
    cout<<("\nEnter the element to be found: ");
    cin>>x;
    bool sorted= checkSorted(arr,n);
    if(!sorted){
        cout<<("Array before sorting: ");
        printArray(arr,n);
        mergesort(arr,0,n-1);
        cout<<("Array after sorting: ");
        printArray(arr,n);
        int result=binarySearch(arr,x,0,n-1);
        printf("\n\n");
        if(result==-1){
            cout<<("NOT FOUND!!");
        }
        else{
            cout<<("Element found at (in the sorted list): ")<<result+1;
        }
    }
    else{
        cout<<("Array: \n");
        printArray(arr,n);
        int result=binarySearch(arr,x,0,n-1);
        if(result==-1){
            cout<<("NOT FOUND!!");
        }
        else{
            cout<<("Element found at: ")<<result+1;
        }
    }
    return 0;
}