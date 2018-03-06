package offer;

public class InversePairs {
    public int InversePairs(int [] array) {

        int count = helper(array, 0, array.length - 1);
        return count;
    }

    private int helper(int[] array, int l, int r) {
        if(l >= r) return 0;

        int mid = (l + r) / 2;
        int count = 0;
        count += helper(array, l, mid);
        count += helper(array, mid + 1, r);

        // left: [l, mid]
        // right: [mid+1, r]
        int[] temp = new int[r - l + 1];
        int t = temp.length - 1;
        int i, j;
        for(i = mid, j = r; i >= l; i--) {
            while(j > mid && array[j] >= array[i]) {
                temp[t--] = array[j];
                j--;
            }
            temp[t--] = array[i];
            count += (j - mid);
            count %= 1000000007;
        }

        while(j > mid) temp[t--] = array[j--];

        for(int k = l; k <= r; k++) {
            array[k] = temp[k - l];
        }

        return count % 1000000007;
    }

    public static void main(String[] args) {
        InversePairs c = new InversePairs();

        int[] arr = {1,2,3,4,5,6,7,0};

        System.out.println(c.InversePairs(arr));
    }
}
