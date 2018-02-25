public class InversePairs {
    public int InversePairs(int [] array) {


        return 0;
    }

    private int helper(int[] array, int l, int r) {
        if(l >= r) return 0;

        int mid = (l + r) / 2;
        int count = 0;
        count += helper(array, l, mid);
        count += helper(array, mid + 1, r);

        //left: [l, mid]
        //right: [mid+1, r]

        return 0;
    }

    public static void main(String[] args) {
        InversePairs c = new InversePairs();

        int[] arr = {1,2,3,4,5,6,7,0};

        System.out.println(c.InversePairs(arr));
    }
}
