package tags.permutations;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int n = nums.length;
        int i = n - 1, j = n - 1;
        while(i > 0) {
            if(nums[i - 1] < nums[i]) {
                while(j >= i) {
                    if(nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        break;
                    }
                    j--;
                }
                break;
            }
            i--;
        }

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
}
