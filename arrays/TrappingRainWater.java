public class TrappingRainWater {
    static int Trap(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        int lMax = 0;
        int rMax = 0;
        int result = 0;
        while (left <= right) {
            if (rMax <= lMax) {
                result += Math.max(0, rMax - arr[right]);
                rMax = Math.max(rMax, arr[right]);
                right -= 1;
            } else {
                result += Math.max(0, lMax - arr[left]);
                lMax = Math.max(lMax, arr[left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;
        System.out.print(Trap(arr, n));
    }
}
