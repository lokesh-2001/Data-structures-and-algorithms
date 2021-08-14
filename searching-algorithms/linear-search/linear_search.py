# linear search function which inputs the array, size of array(n) 
# and the number to be searched (search)
def linearSearch (array,n,search):
    for i in range(n):
        if(array[i]==search):
            return i
    return -1

n = int(input("Enter the size of the list "))
print("\n")
arr = list(int(num) for num in input("Enter elements ").strip().split())[:n]
search=int(input("Enter the value to be searched: "))
result=linearSearch(arr,n,search)
if(result==-1):
    print("NOT FOUND")
else:
    print("FOUND AT INDEX: ", result)
    