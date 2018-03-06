package offer;

public class MovingCount {

    private int count = 0;
    private int[][] vis;

    public int movingCount(int threshold, int rows, int cols)
    {
        vis = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                vis[i][j] = 0;
            }
        }
        here(0, 0, threshold, rows, cols);
        return count;
    }

    private void here(int x, int y, int k, int m, int n) {
        if(can(x, y, k, m, n)) {
            vis[x][y] = 1;
            count++;
            here(x + 1, y, k, m, n);
            here(x - 1, y, k, m, n);
            here(x, y + 1, k, m, n);
            here(x, y - 1, k, m, n);
        }
    }

    private boolean can(int x, int y, int k, int m, int n) {
        if(x < 0 || x >= m) return false;
        if(y < 0 || y >= n) return false;
        if(vis[x][y] == 1) return false;
        return (bitSum(x) + bitSum(y)) <= k;
    }

    private int bitSum(int x) {
        int sum = 0;
        while(x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount c = new MovingCount();
        System.out.println(c.movingCount(10, 1, 100));
    }
}
