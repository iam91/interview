package tags.bfs;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    // https://leetcode.com/problems/surrounded-regions/description/

    public void solve(char[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0) return;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            bfs(board, i, 0, n, m);
            bfs(board, i, m - 1, n, m);
        }

        for(int i = 0; i < m; i++) {
            bfs(board, 0, i, n, m);
            bfs(board, n - 1, i, n, m);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == '+' ? 'O' : 'X';
            }
        }
    }

    private void bfs(char[][] board, int i, int j, int n, int m) {

        if(board[i][j] == 'X') return;

        List<Integer> xq = new ArrayList<>();
        List<Integer> yq = new ArrayList<>();

        xq.add(i);
        yq.add(j);

        while(!xq.isEmpty()) {
            int x = xq.remove(0);
            int y = yq.remove(0);

            board[x][y] = '+';

            if(x > 0 && board[x - 1][y] == 'O') {
                xq.add(x - 1);
                yq.add(y);
            }
            if(x < n - 1 && board[x + 1][y] == 'O') {
                xq.add(x + 1);
                yq.add(y);
            }
            if(y > 0 && board[x][y - 1] == 'O') {
                xq.add(x);
                yq.add(y - 1);
            }
            if(y < m - 1 && board[x][y + 1] == 'O') {
                xq.add(x);
                yq.add(y + 1);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions c = new SurroundedRegions();

//        char[][] board = {
//                {'O', 'O', 'O', 'O', 'X', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'O', 'O'},
//
//        };
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        c.solve(board);
        System.out.println();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        System.out.println(board);
    }
}
