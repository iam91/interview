package lintcode.sort;

public class SortIntegerII {
    /**
     * @param A: an integer array
     * @return: nothing
     */

    public void sortIntegers2(int[] A) {
        // write your code here
        // quickSort(A, 0, A.length - 1);
        // mergeSort(A, 0, A.length - 1);
        // mergeSortII(A);
        heapSort(A);
    }

    private void heapSort(int[] A) {
        int n = A.length;
        // heapify
        for(int i = n / 2; i >= 0; i--) {
            maxHeap(A, i, n - 1);
        }

        for(int i = n - 1; i > 0; i--) {
            swap(A, i, 0);
            maxHeap(A, 0, i - 1);
        }
    }

    private void maxHeap(int[] A, int root, int tail) {
        int parent = root;
        while(parent < tail) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;

            int sinkIdx;
            if(left > tail) return;
            else if(right > tail) sinkIdx = left;
            else if(A[left] > A[right]) sinkIdx = left;
            else sinkIdx = right;

            if(A[parent] >= A[sinkIdx]) return;

            swap(A, parent, sinkIdx);
            parent = sinkIdx;
        }
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

    private void swap(int[] A, int x, int y) {
        int t = A[x];
        A[x] = A[y];
        A[y] = t;
    }
}
