package jd;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int[][][] dp = new int[9][9][k + 1];

        int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

        int newx = 0, newy = 0;
        dp[0][0][0] = 1;
        for (int z = 1; z <= k; z++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][z] = 0;
                    for (int l = 0; l < 8; l++) {
                        newx = i + dx[l];
                        newy = j + dy[l];
                        if (newx >= 0 && newy >= 0 && newx <= 8 && newy <= 8) {
                            dp[i][j][z] = (dp[i][j][z] + dp[newx][newy][z - 1]) % 1000000007;
                            // dp[i][j][z] += (dp[newx][newy][z - 1] % 1000000007);
                        }
                    }
                }
            }
        }
        System.out.println(dp[x][y][k] % 1000000007);
    }
}