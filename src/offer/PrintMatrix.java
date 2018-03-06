package offer;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> ret = new ArrayList<>();

        // check size
        if(matrix == null) return ret;
        int xlen = matrix.length;
        if(xlen == 0) return ret;

        if(matrix[0] == null) return ret;
        int ylen = matrix[0].length;
        if(ylen == 0) return ret;

        // print
        int xstart = 0, xend = xlen - 1;
        int ystart = 0, yend = ylen - 1;
        int x, y;
        boolean flag;
        while(xstart < xend && ystart < yend) {

            x = xstart;
            y = ystart;
            flag = false;
            while(y < yend) {
                ret.add(matrix[x][y]);
                y++;
                flag = true;
            }
            if(flag) yend--;
            flag = false;
            while(x < xend) {
                ret.add(matrix[x][y]);
                x++;
                flag = true;
            }
            if(flag) xend--;
            flag = false;
            while(y > ystart) {
                ret.add(matrix[x][y]);
                y--;
                flag = true;
            }
            if(flag) ystart++;
            flag = false;
            while(x > xstart) {
                ret.add(matrix[x][y]);
                x--;
                flag = true;
            }
            if(flag) xstart++;
        }

        x = xstart;
        y = ystart;

        if(xstart == xend) {
            while(y <= yend) {
                ret.add(matrix[x][y]);
                y++;
            }
        } else if(ystart == yend) {
            while(x <= xend) {
                ret.add(matrix[x][y]);
                x++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        PrintMatrix c = new PrintMatrix();

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6}
//        };

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12}
//        };

//        int[][] matrix = {{1}};

//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};

//        int[][] matrix = {{1, 2, 3, 4, 5}};

        for(int a: c.printMatrix(matrix)) {
            System.out.printf(a + " ");
        }
    }
}
