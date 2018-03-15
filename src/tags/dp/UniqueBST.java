package tags.dp;

public class UniqueBST {
    // https://leetcode.com/problems/unique-binary-search-trees/description/
    public int numTrees(int n) {
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) dp[i][i] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(j == i) dp[i][j] = 1;
                else {
                    int sum = 0;
                    for(int k = i; k <= j; k++) {
                        if(k == i) sum += dp[i + 1][j];
                        else if(k == j) sum += dp[i][j - 1];
                        else sum += dp[i][k - 1] * dp[k + 1][j];
                    }
                    dp[i][j] = sum;
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        UniqueBST c = new UniqueBST();
        System.out.println(c.numTrees(3));
    }
}
