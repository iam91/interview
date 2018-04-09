package jd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int n = s.length();
        long[][] dp = new long[n][n];
        char[] str = s.toCharArray();

        for(int j = 0; j < n; j++){
            dp[j][j] = 1;
            for(int i= j - 1;i >= 0; i--){
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                if(str[i] == str[j]) {
                    dp[i][j] += 1 + dp[i + 1][j - 1];
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}