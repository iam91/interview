public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;

        int[] dp = new int[array.length];
        dp[0] = array[0];

        for(int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
        }
        int max = dp[0];
        for(int d: dp) {
            max = d > max ? d : max;
        }
        return max;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray c = new FindGreatestSumOfSubArray();
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(c.FindGreatestSumOfSubArray(arr));
    }
}
