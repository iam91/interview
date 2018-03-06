package lintcode.sort;

public class SortInteger {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        // selectionSort(A);
        // bubbleSort(A);
        insertionSort(A);
    }

    private void selectionSort(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            int min = A[i];
            int minIdx = i;
            for(int j = i; j < n; j++) {
                if(A[j] < min) {
                    minIdx = j;
                    min = A[j];
                }
            }
            A[minIdx] = A[i];
            A[i] = min;
        }
    }

    private void bubbleSort(int[] A) {
        int n = A.length;

        for(int i = n - 1; i >= 0; i--) {
            // boolean flag = false;
            for(int j = 0; j < i; j++) {
                if(A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                    // flag = true;
                }
            }
            // if(!flag) break;
        }
    }

    private void insertionSort(int[] A) {
        int n = A.length;

        for(int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while(j > 0 && A[j] < A[j - 1]) {
                int t = A[j];
                A[j] = A[j - 1];
                A[j - 1] = t;
                j--;
            }
        }
    }
}
