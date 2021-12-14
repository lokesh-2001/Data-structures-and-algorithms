def getminMax(low,high,arr):
    arr_max = arr[low]
    arr_min = arr[low]
    # one element
    if(low == high):
        arr_max = arr[low]
        arr_min = arr[low]
        return (arr_max,arr_min)
    
    elif(high == low +1):
        if(arr[low] > arr[high]):
            arr_max = arr[low]
            arr_min = arr[high]
        else:
            arr_max = arr[high]
            arr_min = arr[low]
        return (arr_max,arr_min)
    mid = int((low+high)/2)
    arr_max_1,arr_min_1 = getminMax(low,mid,arr)
    arr_max_2,arr_min_2 = getminMax(mid+1,high,arr)

    return(max(arr_max_1,arr_max_2),min(arr_min_1,arr_min_2))
arr = [ 1000,1,445,11,3000,745]
# high = len(arr)-1
# low =0
arr_max,arr_min = getminMax(0,len(arr)-1,arr)
print('minimum element : ', arr_min)
print('maximum element : ', arr_max)