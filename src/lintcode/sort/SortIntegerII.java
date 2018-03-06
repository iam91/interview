package lintcode.sort;

public class SortIntegerII {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
//        quickSort(A, 0, A.length - 1);
        mergeSortII(A);
    }

//    private void quickSort(int[] A, int l, int r) {
//        if(l >= r) return;
//
//        int pivot = A[l];
//        int pivotIdx = l;
//
//        // partition
//        int i = l, j = r;
//        while(i < j) {
//            while(i < j && A[j] > pivot) {
//                j--;
//            }
//            swap(A, j, pivotIdx);
//            pivotIdx = j;
//
//            while(i < j && A[i] <= pivot) {
//                i++;
//            }
//            swap(A, i, pivotIdx);
//            pivotIdx = i;
//        }
//
//        quickSort(A, l, pivotIdx - 1);
//        quickSort(A, pivotIdx + 1, r);
//    }

    private void quickSort(int[] A, int l, int r) {
        if(l >= r) return;

        int pivot = A[l];

        // partition
        int i = l, j = r;
        while(i < j) {
            while(i < j && A[j] > pivot) {
                j--;
            }
            A[i] = A[j];

            while(i < j && A[i] <= pivot) {
                i++;
            }
            A[j] = A[i];
        }

        A[i] = pivot;

        quickSort(A, l, i - 1);
        quickSort(A, i + 1, r);
    }

    private void mergeSort(int[] A, int l, int r) {
        if(l >= r) return;

        int[] a = new int[r - l + 1];

        int mid = (l + r) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r) {
            if(A[i] > A[j]) a[k++] = A[j++];
            else a[k++] = A[i++];
        }

        while(i <= mid) a[k++] = A[i++];
        while(j <= r) a[k++] = A[j++];

        for(k = 0; k < a.length; k++) {
            A[l + k] = a[k];
        }
    }

    private void mergeSortII(int[] A) {

        int n = A.length;
        int[] a = new int[n];

        int len = 1;
        while(len < n) {
            int l = 0;
            int mid = l + len;
            while(mid < n) {
                int r = Math.min(mid + len - 1, n - 1);

                int i = l, j = mid, k = l;
                while(i < mid && j <= r) {
                    if(A[i] > A[j]) a[k++] = A[j++];
                    else a[k++] = A[i++];
                }

                while(i < mid) a[k++] = A[i++];
                while(j <= r) a[k++] = A[j++];

                for(k = l; k <= r; k++) {
                    A[k] = a[k];
                }

                l = l + 2 * len;
                mid = l + len;
            }

            len *= 2;
        }
    }

    private void swap(int[] A, int x, int y) {
        int t = A[x];
        A[x] = A[y];
        A[y] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5};
        SortIntegerII c = new SortIntegerII();
        c.sortIntegers2(arr);

        for(int a: arr) {
            System.out.println(a);
        }
    }
}
