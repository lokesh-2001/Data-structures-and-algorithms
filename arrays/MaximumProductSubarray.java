public class MaximumProductSubarray {
    static int min(int x,int y){
        return x<y?y:x;
    }
    static int max(int x,int y){
        return x>y?x:y;
    }
    static int productSub(int arr[]){
        int n = arr.length;
        int max_end=1;
        int min_end=1;
        int max_far=1;
        int flag=0;
        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                max_end = max_end * arr[i];
                min_end = min(min_end*arr[i],1);
            }
            else if(arr[i] == 0){
                max_end = 1;
                min_end = 1;
            }
            else{
                int temp = max_end;
                max_end = max(min_end*arr[i],1);
                min_end = temp*arr[i];
            }
            if(max_far < max_end)
                max_far = max_end;
        }
        if(flag==0 && max_far==0)
            return 0;            
        return max_far;
    }
    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println("Maximum Sub array product is "
                           + productSub(arr)); 
    }

}
