package tags.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        // return sort(nums, k);
        // return priority(nums, k);
        return partition(nums, k);
    }

    public int partition(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;

        int i, j;
        do {
            i = l;
            j = r;
            int pivot = nums[i];
            while(i < j) {
                while(i < j && nums[j] > pivot) j--;
                nums[i] = nums[j];
                while(i < j && nums[i] <= pivot) i++;
                nums[j] = nums[i];
            }
            nums[i] = pivot;

            if(i < n - k) l = i + 1;
            else r = i - 1;
        } while(i != n - k);

        return nums[i];
    }

    public int priority(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        while(i < k) {
            q.offer(nums[i++]);
        }
        while(i < n) {
            if(nums[i] > q.peek()) {
                q.poll();
                q.offer(nums[i]);
            }
            i++;
        }
        return q.peek();
    }

    public int sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthLargest c = new KthLargest();
        int[] n = {2,1};
        int k = 2;
        System.out.println(c.findKthLargest(n, k));
    }
}
