package tags.dp;

public class LICS {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return 0;

        int n = A.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        int max1 = 0, max2 = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                dp1[i] = dp2[i] = 1;
            } else {
                dp1[i] = A[i] > A[i - 1] ? dp1[i - 1] + 1 : 1;
                dp2[i] = A[i] < A[i - 1] ? dp2[i - 1] + 1 : 1;
            }
            max1 = dp1[i] > max1 ? dp1[i] : max1;
            max2 = dp2[i] > max2 ? dp2[i] : max2;
        }

        return max1 > max2 ? max1 : max2;
    }
}
