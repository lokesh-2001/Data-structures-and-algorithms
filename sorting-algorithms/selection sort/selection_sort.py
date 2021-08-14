def selectionSort(arr,n):
    for i in range (n-1):
        smallest =i
        # to find smallest element in array 
        for j in range(i+1,n):
            if arr[j]<arr[smallest]:
                smallest =j
        if smallest!=i:
            arr[i],arr[smallest]=arr[smallest],arr[i]

def printArr(arr):
    for element in arr:
        print(element,end=" ")
    print("")
n = int(input("Enter the size of the list "))
print("\n")
arr = list(int(num) for num in input("Enter elements ").strip().split())[:n]
print("Unsorted List: ")
printArr(arr)
selectionSort(arr,n)
print("\n")
printArr(arr)





