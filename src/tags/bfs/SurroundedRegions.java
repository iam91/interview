package tags.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0) return;

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    //bfs
                    bfs(board, visited, i, j, n, m);
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] visited, int i, int j, int n, int m) {

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        LinkedList<Integer> xv = new LinkedList<>();
        LinkedList<Integer> yv = new LinkedList<>();

        xq.offer(i);
        yq.offer(j);

        boolean flag = false;

        while(!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();

            xv.offer(x);
            yv.offer(y);

            visited[x][y] = true;
            if(x <= 0 || y <= 0 || x >= n - 1 || y >= m - 1) flag = true;

            if(x > 0 && !visited[x - 1][y] && board[x - 1][y] == 'O') {
                xq.offer(x - 1);
                yq.offer(y);
            }
            if(x < n - 1 && !visited[x + 1][y] && board[x + 1][y] == 'O') {
                xq.offer(x + 1);
                yq.offer(y);
            }
            if(y > 0 && !visited[x][y - 1] && board[x][y - 1] == 'O') {
                xq.offer(x);
                yq.offer(y - 1);
            }
            if(y < m - 1 && visited[x][y + 1] && board[x][y + 1] == 'O') {
                xq.offer(x);
                yq.offer(y + 1);
            }
        }

        if(!flag) {
            for(int ii = 0; ii < xv.size(); ii++) {
                board[xv.get(ii)][yv.get(ii)] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions c = new SurroundedRegions();

        char[][] board = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'},

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
