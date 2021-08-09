def bubbleSort(arr,size):
    for i in range(size-1):
        swapped=False
        for j in range(size-i-1):
            if arr[j]>arr[j+1]:
                # swapping
                arr[j],arr[j+1]=arr[j+1],arr[j]
                swapped=True
        # if no elements were swapped that means no swapping has taken place
        # list already sorted
        if not swapped:
            break
def printArr(arr):
    for element in arr:
        print(element,end=" ")
    print("")
n = int(input("Enter the size of the list "))
print("\n")
arr = list(int(num) for num in input("Enter elements ").strip().split())[:n]
print("Unsorted List: ")
printArr(arr)
bubbleSort(arr,n)
print("\n")
printArr(arr)





