package tags.sort;

public class SortColors {
    // https://leetcode.com/problems/sort-colors/description/

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;

        int k = 0;
        while(k < n && nums[k] != 1) k++;
        if(k < n)
            swap(nums, 0, k);

        int pivot = nums[0];
        int i = 0, j = n - 1;
        int p = 0, q = n - 1;
        while(i < j) {
            while(i < j && nums[j] >= pivot) {
                if(nums[j] == pivot) {
                     swap(nums, j, q--);
                }
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot) {
                if(nums[i] == pivot) {
                     swap(nums, i, p++);
                }
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;

        for(int a = i + 1, b = n - 1; b > q; a++, b--) {
            swap(nums, a, b);
        }
        for(int a = i - 1, b = 0; b < p; a--, b++) {
            swap(nums, a, b);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        SortColors c = new SortColors();

        int[] a = {1, 2, 0, 0, 2, 1, 1, 2, 1, 0, 2, 2, 0, 1, 1};

//        int[] a = {0};

        c.sortColors(a);

        for(int aa: a) {
            System.out.print(aa + " ");
        }
    }
}
