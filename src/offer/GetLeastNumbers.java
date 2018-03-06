package offer;

import java.util.*;

public class GetLeastNumbers {
//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//
//        ArrayList<Integer> ret = new ArrayList<>();
//
//        if(k == 0 || input.length == 0) return ret;
//
//        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        for(int i = 0; i < input.length; i++) {
//            if(p.size() < k) {
//                p.offer(input[i]);
//            } else {
//                if(input[i] < p.peek()) {
//                    p.poll();
//                    p.offer(input[i]);
//                }
//            }
//        }
//
//        if(p.size() >= k) {
//            for(Integer t: p) {
//                ret.add(t);
//            }
//        }
//
//
//        return ret;
//    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(k == 0 || input.length == 0) return ret;
        Arrays.sort(input);

        if(input.length >= k) {
            for(int i = 0; i < k; i++) {
                int t = input[i];
                ret.add(t);
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        GetLeastNumbers c = new GetLeastNumbers();

        int[] in = {4,5,1,6,2,7,3,8};


        for(int i: c.GetLeastNumbers_Solution(in, 4)) {
            System.out.println(i);
        }
    }
}