# Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
def printA(arr, n):
    for i in range(n):
        print(arr[i],end=" ")
def sort(arr,n):
    c1=0
    c2=0
    c3=0
    for i in range(n):
        if(arr[i] == 0):
            c1+=1
        elif(arr[i] == 1):
            c2+=1
        else:
            c3+=1
    i = 0
    while(c1>0):
        arr[i] = 0
        i+=1
        c1-=1
    while(c2>0):
        arr[i] = 1
        i+=1
        c2-=1
    while(c3>0):
        arr[i] = 2
        i+=1
        c3-=1
    printA(arr,n)

arr = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
n = len(arr)
sort(arr,n)