package leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        return findIII(nums, k);
    }

    private int findII(int[] nums, int k) {

        int targetIdx = nums.length - k;
        int i = 0, j = nums.length - 1;
        while(true) {
            int pivIdx = partition(nums, i, j);
            if(pivIdx < targetIdx) i = pivIdx + 1;
            else if(pivIdx > targetIdx) j = pivIdx - 1;
            else return nums[pivIdx];
        }
    }

    private int partition(int[] nums, int l, int r) {

        int pivot = nums[l];

        int i = l, j = r;
        while(i < j) {
            while(i < j && nums[j] > pivot) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot) i++;
            nums[j] = nums[i];
        }

        nums[i] = pivot;
        return i;
    }

    private int find(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int findIII(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int i = 0;
        while(i < k) {
            q.add(nums[i++]);
        }
        while(i < nums.length) {
            if(nums[i] > q.peek()) {
                q.poll();
                q.offer(nums[i]);
            }
            i++;
        }
        return q.peek();
    }
}
