// Calculate square of a number without using *, / and pow()
public class square {
    static int findSquare(int n){
        n = Math.abs(n);
        int temp = n, result = 0, pos = 0;
        while(temp > 0){
            if((temp & 1 ) == 1)
                result += n<<pos;
            pos++;
            temp = temp>>1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findSquare(5));
    }

}
