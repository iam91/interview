package lintcode.dp.oneD;

public class LICS {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return 0;

        int n = A.length;
        int[] dpl = new int[n];
        int[] dpr = new int[n];

        // init
        for(int i = 0; i < n; i++) {
            dpl[i] = dpr[i] = 0;
        }

        dpl[0] = dpr[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
            dpl[i] = 1 + (A[i] > A[i - 1] ? dpl[i - 1] : 0);
            dpr[i] = 1 + (A[i] < A[i - 1] ? dpr[i - 1] : 0);
            if(dpl[i] > max) max = dpl[i];
            if(dpr[i] > max) max = dpr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        LICS c = new LICS();
        int[] A = {5,4,2,1,3};
        System.out.println(c.longestIncreasingContinuousSubsequence(A));
    }
}
