package leetcode.permutation;



public class NextPermutation {
    // 1.next permutation
    // 2.array reversion
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;

        int i = n - 1, j = n - 1;
        while(i > 0) {
            if(nums[i - 1] < nums[i]) {
                while(j >= i) {
                    if(nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                    j--;
                }
                break;
            }
            i--;
        }

        //reverse
        j = n - 1;
        while(i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        NextPermutation c = new NextPermutation();

        int[] n = {1,1};

        c.nextPermutation(n);

        int t = 0;
    }
}
