package tags.median;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    // https://leetcode.com/problems/find-median-from-data-stream/description/

    private PriorityQueue<Integer> lower;
    private PriorityQueue<Integer> higher;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.lower = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.higher = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(this.lower.size() == 0) this.lower.add(num);
        else if(this.lower.size() == this.higher.size()) {
            if(num > this.higher.peek()) {
                this.lower.add(this.higher.poll());
                this.higher.add(num);
            } else {
                this.lower.add(num);
            }
        } else {
            if(num < this.lower.peek()) {
                this.higher.add(this.lower.poll());
                this.lower.add(num);
            } else {
                this.higher.add(num);
            }
        }
    }

    public double findMedian() {
        if(this.lower.size() == this.higher.size()) {
            return ((double)this.lower.peek() + this.higher.peek()) / 2;
        } else {
            return this.lower.peek();
        }
    }
}
