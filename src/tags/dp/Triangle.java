package tags.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    // https://leetcode.com/problems/triangle/description/

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];

        int pre = 0;
        int curr = 1;
        dp[pre][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> currLevel = triangle.get(i);
            dp[curr][0] = currLevel.get(0) + dp[pre][0];
            for(int j = 1; j < currLevel.size(); j++) {
                if(j == currLevel.size() - 1)
                    dp[curr][j] = dp[pre][j - 1] + currLevel.get(j);
                else
                    dp[curr][j] = Math.min(dp[pre][j - 1], dp[pre][j]) + currLevel.get(j);
            }
            int t = pre;
            pre = curr;
            curr = t;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = dp[pre][i] > min ? min : dp[pre][i];
        }
        return min;
    }

    public static void main(String[] args) {
        Triangle c = new Triangle();

        List<List<Integer>> t = new ArrayList<>();
        Integer[] l1 = {2};
        Integer[] l2 = {3, 4};
        Integer[] l3 = {6, 5, 7};
        Integer[] l4 = {4, 1, 8, 3};

        t.add(Arrays.asList(l1));
        t.add(Arrays.asList(l2));
        t.add(Arrays.asList(l3));
        t.add(Arrays.asList(l4));

        System.out.println(c.minimumTotal(t));
    }
}
