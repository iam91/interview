package tags.sort;

import java.util.*;

public class TopKFrequent {
    //

    public List<Integer> topKFrequent(int[] nums, int k) {
//        return priorityQueue(nums, k);
        return bucketSort(nums, k);
    }

    private HashMap<Integer, Integer> count(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n: nums) {
            if(count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else count.put(n, 1);
        }
        return count;
    }

    private List<Integer> bucketSort(int[] nums, int k) {

        HashMap<Integer, Integer> count = count(nums);
        List<Integer>[] bucket = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new LinkedList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        LinkedList<Integer> ret = new LinkedList<>();
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) ret.addAll(bucket[i]);
            if(ret.size() == k) break;
        }

        return ret;
    }

    private List<Integer> priorityQueue(int[] nums, int k) {

        HashMap<Integer, Integer> count = count(nums);

        Map.Entry<Integer, Integer>[] heap = new Map.Entry[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(i < k) {
                heap[i++] = entry;
                if(i == k) {
                    // build a heap
                    for (int ii = k / 2; ii >= 0; ii--) sink(heap, ii, k - 1);
                }
            } else {
                // insert
                if(entry.getValue() > heap[0].getValue()) {
                    heap[0] = entry;
                    sink(heap, 0, k - 1);
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: heap) {
            ret.add(entry.getKey());
        }

        return ret;
    }

    private void sink(Map.Entry<Integer, Integer>[] heap, int i, int j) {
        if(i >= j) return;
        int p = i;
        while(p < j) {
            int l = p * 2 + 1;
            int r = p * 2 + 2;

            int idx = p;
            if(r <= j && heap[r].getValue() < heap[l].getValue()) idx = r;
            else if(l <= j) idx = l;

            if(heap[idx].getValue() < heap[p].getValue()) {
                Map.Entry<Integer, Integer> t = heap[idx];
                heap[idx] = heap[p];
                heap[p] = t;
                p = idx;
            } else break;
        }
    }

    public static void main(String[] args) {
        TopKFrequent c = new TopKFrequent();

        int[] numbers = {1,2};
        int k = 2;
        System.out.println(c.bucketSort(numbers, k));
//        System.out.println(c.priorityQueue(numbers, k));
    }
}
