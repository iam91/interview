package tags.search;

public class SearchForRange {
    // https://leetcode.com/problems/search-for-a-range/description/

    public int[] searchRange(int[] nums, int target) {

        int[] ret = new int[2];

        if(nums == null || nums.length == 0) ret[0] = ret[1] = -1;
        else {
            ret[0] = lower_bound(nums, target, 0, nums.length - 1);
            ret[1] = upper_bound(nums, target, 0, nums.length - 1);
        }
        return ret;
    }

    private int upper_bound(int[] nums, int target, int l, int r) {
        if(l > r) return -1;
        int mid = (l + r) / 2;

        if(nums[mid] > target) return upper_bound(nums, target, l, mid - 1);
        else if(nums[mid] < target) return upper_bound(nums, target, mid + 1, r);
        else {
            if(mid >= r || nums[mid + 1] != target) return mid;
            else return upper_bound(nums, target, mid + 1, r);
        }
    }

    private int lower_bound(int[] nums, int target, int l, int r) {
        if(l > r) return -1;
        int mid = (l + r) / 2;

        if(nums[mid] > target) return lower_bound(nums, target, l, mid - 1);
        else if(nums[mid] < target) return lower_bound(nums, target, mid + 1, r);
        else {
            if(mid <= l || nums[mid - 1] != target) return mid;
            else return lower_bound(nums, target, l, mid - 1);
        }
    }
}
