package offer;

public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array, int num1[], int num2[]) {
        int all = 0;
        for(int a: array) {
            all ^= a;
        }
        int k = 0;
        while((all & 0x01) == 0) {
            k++;
            all >>>= 1;
        }
        int mask = 0x01;
        while(k > 0) {
            mask <<= 1;
            k--;
        }

        num1[0] = num2[0] = 0;
        for(int a: array) {
            if((a & mask) != 0) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }

//    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < array.length; i++) {
//            int curr = array[i];
//            if(!map.containsKey(curr)) {
//                map.put(curr, 1);
//            } else {
//                map.put(curr, 2);
//            }
//        }
//
//        int k = 0;
//        for(Integer key: map.keySet()) {
//            if(map.get(key) == 1) {
//                if(k == 0) {
//                    num1[0] = key;
//                    k++;
//                } else {
//                    num2[0] = key;
//                    break;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        offer.FindNumsAppearOnce c = new offer.FindNumsAppearOnce();
        int[] arr = {1, 2, 2, 4, 4, 5, 3, 3};
        int[] n1 = new int[2];
        int[] n2 = new int[2];
        c.findNumsAppearOnce(arr, n1, n2);
        System.out.printf(n1[0] + " " + n2[0]);
    }
}