package tags.sort;

public class SortIntegerII {
    // n log(n) algorithms
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        // quickSort(A, 0, A.length - 1);
        // heapSort(A);
        // mergeSort(A);
        mergeSortII(A);
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

                int k = l, i = l, j = mid;
                while(i < mid && j <= r) {
                    if(A[i] <= A[j]) a[k++] = A[i++];
                    else a[k++] = A[j++];
                }
                while(i < mid) a[k++] = A[i++];
                while(j <= r) a[k++] = A[j++];

                for(k = l; k <= r; k++) A[k] = a[k];

                l = l + 2 * len;
                mid = l + len;
            }
            len = len * 2;
        }
    }

    private void mergeSort(int[] A) {
        int[] a = new int[A.length];
        mergeSort(A, a, 0, A.length - 1);
    }

    private void mergeSort(int[] A, int[] a, int l, int r) {
        if(l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(A, a, l, mid);
        mergeSort(A, a, mid + 1, r);

        int k = l, i = l, j = mid + 1;
        while(i <= mid && j <= r) {
            if(A[i] <= A[j]) a[k++] = A[i++];
            else a[k++] = A[j++];
        }

        while(i <= mid) a[k++] = A[i++];
        while(j <= r) a[k++] = A[j++];

        for(k = l; k <= r; k++) A[k] = a[k];
    }

    private void quickSort(int[] A, int l, int r) {
        if(l >= r) return;

        int pivot = A[l];
        int i = l, j = r;
        while(i < j) {
            while(i < j && A[j] > pivot) j--;
            A[i] = A[j];
            while(i < j && A[i] <= pivot) i++;
            A[j] = A[i];
        }
        A[i] = pivot;

        quickSort(A, l, i - 1);
        quickSort(A, i + 1, r);
    }

    private void heapSort(int[] A) {
        int n = A.length;
        for(int i = n / 2; i >= 0; i--) {
            maxHeap(A, i, n - 1);
        }

        for(int i = n - 1; i > 0; i--) {
            swap(A, 0, i);
            maxHeap(A, 0, i - 1);
        }
    }

    private void maxHeap(int[] A, int l, int r) {
        if(l >= r) return;
        int p = l;
        while(p <= r) {
            int left = p * 2 + 1;
            int right = p * 2 + 2;
            int idx;
            if(right <= r && A[right] > A[left]) idx = right;
            else if(left <= r) idx = left;
            else idx = p;

            if(A[idx] > A[p]){
                swap(A, idx, p);
                p = idx;
            } else {
                break;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
