def checkSorted(arr,n):
    flag=0
    if(arr==sorted(arr)):
        flag =1
    return flag


def binarySearch(array, x, low, high):

    if high >= low:

        mid = low + (high - low)//2

        # If found at mid, then return it
        if array[mid] == x:
            return mid

        # Search the left half
        elif array[mid] > x:
            return binarySearch(array, x, low, mid-1)

        # Search the right half
        else:
            return binarySearch(array, x, mid + 1, high)

    else:
        return -1

def merge_sort(inp_arr):
    size = len(inp_arr)
    if size > 1:
        middle = size // 2
        left_arr = inp_arr[:middle]
        right_arr = inp_arr[middle:]
 
        merge_sort(left_arr)
        merge_sort(right_arr)
 
        p = 0
        q = 0
        r = 0
 
        left_size = len(left_arr)
        right_size = len(right_arr)
        while p < left_size and q < right_size:
            if left_arr[p] < right_arr[q]:
              inp_arr[r] = left_arr[p]
              p += 1
            else:
                inp_arr[r] = right_arr[q]
                q += 1
             
            r += 1
 
        
        while p < left_size:
            inp_arr[r] = left_arr[p]
            p += 1
            r += 1
 
        while q < right_size:
            inp_arr[r]=right_arr[q]
            q += 1
            r += 1
def printArr(arr):
    for element in arr:
        print(element,end=" ")
    print("")

n = int(input("Enter the size of the list "))
print("\n")
arr = list(int(num) for num in input("Enter elements ").strip().split())[:n]
search=int(input("Enter the value to be searched: "))
sorted= checkSorted(arr,n)
if (not sorted):
    print("Unsorted List: ")
    printArr(arr)
    merge_sort(arr)
    print("\n")
    printArr(arr)
    result = binarySearch(arr, search, 0, len(arr)-1)

    if result != -1:
        print("Element is present at index " + str(result+1))
    else:
        print("Not found")
else:
    result = binarySearch(arr, search, 0, len(arr)-1)

    if result != -1:
        print("Element is present at index " + str(result+1))
    else:
        print("Not found")

