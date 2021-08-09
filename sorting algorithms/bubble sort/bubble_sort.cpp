#include <iostream>
#include<stdlib.h>
using namespace std;
// Function to perform Bubble Sort
void bubbleSort(int arr[], int size)
{
    // Loop to access each element of the array
    for (int i = 0; i < (size - 1); i++)
    {
        // Variable to check if swapping occurs
        bool swapped = false;
        // loop to compare two adjacent elements of the array
        for (int j = 0; j < (size - i - 1); j++)
        {
            // Comparing two adjacent array elements
            if (arr[j] > arr[j + 1])
            {
                // Swap both elements if they're
                // not in correct order
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        // If no elements were swapped that means the array is sorted now,
        // then break the loop.
        if (swapped == false)
        {
            break;
        }
    }
}
// Prints the elements of the array
void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main()
{
    system("cls");
    int arr[100],n;
    cout<<"Enter the number of elements of the array: ";
    cin>>n;
    for(int i=0;i<n;i++){
        cout<<"Element: ";
        cin>>arr[i];
    }
    cout<<endl<<endl;
    cout<<"The Unsorted Array is: ";
    printArray(arr, n);
    bubbleSort(arr,n);
    cout<<endl<<endl;
    cout<<"Sorted Array is: ";
    printArray(arr,n);
    return 0;
}