package tags.search;

public class SearchMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/description/

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return searchAll(matrix, target, 0, matrix.length - 1);
    }

    private boolean searchAll(int[][] matrix, int target, int l, int r) {

        if(l > r) return false;

        int mid = (l + r) / 2;
        if(matrix[mid][0] > target) {
            if(l >= mid) return false;
            else if(l == mid - 1) return searchRow(matrix[l], target, 0, matrix[l].length - 1);
            else if(l < mid - 1) return searchAll(matrix, target, l, mid - 1);
        } else if(matrix[mid][0] < target) {
            if(r >= mid) return searchRow(matrix[mid], target, 0, matrix[r].length - 1)
                    || searchAll(matrix, target, mid + 1, r);
            else return false;
        }
        return true;
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
        SearchMatrix c = new SearchMatrix();

//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
        int[][] matrix = {{1}};

        System.out.println(c.searchMatrix(matrix, 2));
    }
}
