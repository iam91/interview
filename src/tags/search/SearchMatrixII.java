package tags.search;

public class SearchMatrixII {
    // https://leetcode.com/problems/search-a-2d-matrix-ii/description/

    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target);
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//
//        int headBound = searchHead(matrix, target, 0, matrix.length - 1);
//        if(headBound == -1) return false;
//        int tailBound = searchTail(matrix, target, 0, matrix.length - 1);
//        if(tailBound == -1) return false;
//
//        for(int i = tailBound; i <= headBound; i++) {
//            if(searchRow(matrix[i], target, 0, matrix[i].length - 1)) return true;
//        }
//        return false;
    }

    private boolean search(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int x = n - 1;
        int y = 0;

        while(x >= 0 && y < m) {
            if(matrix[x][y] > target) x--;
            else if(matrix[x][y] < target) y++;
            else return true;
        }

        return false;
    }

    private int searchTail(int[][] matrix, int target, int l, int r) {
        int mid = (l + r) / 2;
        int t = matrix[0].length - 1;

        if(matrix[mid][t] < target) {
            if(mid == r) return 0;
            else return searchTail(matrix, target, mid + 1, r);
        } else {
            if(mid == l) return mid;
            else if(l + 1 == mid) {
                if(matrix[l][t] < target) return mid;
                else return l;
            } else return searchTail(matrix, target, l, mid);
        }
    }

    private int searchHead(int[][] matrix, int target, int l, int r) {

        int mid = (l + r) / 2;

        if(matrix[mid][0] > target) {
            if(mid == l) return -1;
            else return searchHead(matrix, target, l, mid - 1);
        } else {
            if(mid == r) return mid;
            else if(mid == r - 1) {
                if (matrix[r][0] > target) return mid;
                else return r;
            } else return searchHead(matrix, target, mid, r);
        }
    }

    private boolean searchRow(int[] arr, int target, int l, int r) {

        if(l > r) return false;

        int mid = (l + r) / 2;
        if(arr[mid] > target) {
            return searchRow(arr, target, l, mid - 1);
        } else if(arr[mid] < target) {
            return searchRow(arr, target, mid + 1, r);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        SearchMatrixII c = new SearchMatrixII();

        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
//        int[][] matrix = {{5}, {6}};

        System.out.println(c.searchMatrix(matrix, 5));
    }
}
