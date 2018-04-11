package tags.dfs;

/**
 * Created by zwy on 18-4-11.
 */
public class LongestIncreasingPathInMatrix {
    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {


        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] mem = new int[n][m];

        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 2 && j == 1) {
                    int a = 1;
                }
                max = Math.max(max, dfs(matrix, mem, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] mem, int x, int y) {
        if(mem[x][y] > 0) return mem[x][y];

        int n = matrix.length;
        int m = matrix[0].length;
        int up = x > 0 && matrix[x - 1][y] > matrix[x][y] ? dfs(matrix, mem, x - 1, y) : 0;
        int left = y > 0 && matrix[x][y - 1] > matrix[x][y] ? dfs(matrix, mem, x, y - 1) : 0;
        int down = x < n - 1 && matrix[x + 1][y] > matrix[x][y] ? dfs(matrix, mem, x + 1, y) : 0;
        int right = y < m - 1 && matrix[x][y + 1] > matrix[x][y] ? dfs(matrix, mem, x, y + 1) : 0;

        return mem[x][y] = (Math.max(up, Math.max(left, Math.max(down, right))) + 1);
    }

    public static void main(String[] args) {
        LongestIncreasingPathInMatrix c = new LongestIncreasingPathInMatrix();

//        int[][] m = {
//                {9,9,4},
//                {6,6,8},
//                {2,1,1}
//        };

//        int[][] m = {
//                {3,4,5},
//                {3,2,6},
//                {2,2,7}
//        };

        int[][] m = new int[14][10];

        int j = 0;
        int cc = 0;
        for(int i = 0; i < 13; i++) {
            if(j <= 0) {
                j = 0;
                while(j < 10) m[i][j++] = cc++;
            } else {
                j = 10 - 1;
                while(j >= 0) m[i][j--] = cc++;
            }
        }
        for(int i = 0; i < 10; i++) m[13][i++] = 0;

        System.out.println(c.longestIncreasingPath(m));
    }
}
