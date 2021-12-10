public class permutation{
    // swap function
    private static String swap(String str, int x, int y){
        char t;
        char[] chrArr = str.toCharArray();
        t = chrArr[x];
        chrArr[x] = chrArr[y];
        chrArr[y] = t;
        return String.valueOf(chrArr);

    }
    // finding permutation fun
    private static void  permutations(String str , int i , int j){
        
        if(i == j){
            System.out.println(str);
            return;
        }
        for(int k = i; k <= j; k++){
            // do
            str = swap(str,i,k);
            // recursion
            permutations(str,i+1,j);
            // undo
            str =  swap(str,i,k);
        }

    }
    public static void main(String[] args){
        String str = "abc";
        // string , left boundary, right boundary
        permutations(str, 0 ,str.length()-1);
    }
}