#include <stdio.h>
#include<stdlib.h>
void selectionSort(int arr[], int n)
{
    int smallest=0,i=0,j=0,temp=0;
    for(i=0;i<n-1;i++)
    {
        smallest=i;
        for(j=i+1;j<n;j++)
        {
            if(arr[j]<arr[smallest])
            smallest=j;
        }
        if (smallest!=i)
        {
            
            temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }
    }

    // print the sorted array
    printf("Sorted Array: ");
    for(i=0;i< n;i++)
    {
        printf("%d  ", arr[i]);
    }
}

int main()
{
    system("cls");
    int arr[100], n;
    // ask user for number of elements to be sorted
    printf("Enter the number of elements to be sorted: ");
    scanf("%d", &n);
    // input elements if the array
    for(int i=0;i<n;i++)
    {
        printf("Enter element no. %d: ", i+1);
        scanf("%d", &arr[i]);
    }
    // call the function bubbleSort
    selectionSort(arr, n);
    
    return 0;
}