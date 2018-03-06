package offer;

public class HasPath {

    private boolean[] vis;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || matrix.length == 0) return false;
        if(str == null || str.length == 0) return false;

        vis = new boolean[rows * cols];
        for(int i = 0; i < vis.length; i++) vis[i] = false;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(helper(matrix, rows, cols, str, i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean helper(char[] matrix, int rows, int cols, char[] str, int x, int y, int k) {
        if(x < 0 || x >= rows) return false;
        if(y < 0 || y >= cols) return false;


        int idx = x * cols + y;
        if(!vis[idx] && matrix[idx] == str[k]) {
            vis[idx] = true;
            boolean ret;
            if(k == str.length - 1) ret = true;
            else ret = helper(matrix, rows, cols, str, x + 1, y, k + 1)
                    || helper(matrix, rows, cols, str, x - 1, y, k + 1)
                    || helper(matrix, rows, cols, str, x, y + 1, k + 1)
                    || helper(matrix, rows, cols, str, x, y - 1, k + 1);
            vis[idx] = false;
            return ret;
        } else return false;
    }

    public static void main(String[] args) {
        HasPath c = new HasPath();

        //char[] matrix = "abcesfcsadee".toCharArray();
        //char[] str = "abcb".toCharArray();

        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        System.out.println(c.hasPath(matrix, 5, 8, str));
    }
}
