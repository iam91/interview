package tags.backtrack;

public class WordSearch {
    private final static int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(board, i, j, word, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int deep) {

        if(word.charAt(deep - 1) != board[x][y]) return false;
        if(deep == word.length()) return true;

        int n = board.length;
        int m = board[0].length;

        boolean ret = false;

        char c = board[x][y];
        board[x][y] = '0';

        for(int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != '0')
                ret = ret || dfs(board, x + dir[d][0], y + dir[d][1], word, deep + 1);
        }
        board[x][y] = c;

        return ret;
    }

    public static void main(String[] args) {
        WordSearch c = new WordSearch();

//        char[][] board = {
//                {'a', 'b', 'c', 'e'},
//                {'s', 'f', 'c', 's'},
//                {'a', 'd', 'e', 'e'}
//        };

        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}
        };

        System.out.println(c.exist(board, "abcd"));
    }
}
