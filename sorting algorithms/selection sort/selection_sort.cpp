#include <iostream>
#include <stdlib.h>
using namespace std;
// Function to perform Bubble Sort
void selectionSort(int arr[], int size)
{
    // Loop to access each element of the array
    int smallest = 0;
    for (int i = 0; i < (size - 1); i++)
    {
        // Variable to check if swapping occurs
        int smallest = i;
        // loop to compare two adjacent elements of the array
        for (int j = i + 1; j < size; j++)
        {
            // Comparing two adjacent array elements
            if (arr[j] < arr[smallest])
            {
                smallest = j;
            }
        }
        if (smallest != i)
        {
            // Swap both elements if they're
            // not in correct order
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
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
    int arr[100], n;
    cout << "Enter the number of elements of the array: ";
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cout << "Element: ";
        cin >> arr[i];
    }
    cout << endl
         << endl;
    cout << "The Unsorted Array is: ";
    printArray(arr, n);
    selectionSort(arr, n);
    cout << endl
         << endl;
    cout << "Sorted Array is: ";
    printArray(arr, n);
    return 0;
}