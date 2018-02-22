public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array == null || array.length == 0) return 0;

        int val = array[0];
        int count = 1;

        for(int i = 1; i < array.length; i++) {
            int t = array[i];

            if(count == 0) {
                val = t;
                count = 1;
            } else if(t == val) {
                count++;
            } else {
                count--;
            }
        }

        //check
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == val) {
                count++;
            }
        }

        if(count * 2 > array.length) {
            return val;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MoreThanHalfNum c = new MoreThanHalfNum();
        int[] arr = {2,2,2,2,2,1,3,4,5};
//        int[] arr = {1,2,3,2,2,2,5,4,2};
//        int[] arr = {1,1,2,2,3,3,5,4,2};

        System.out.println(c.MoreThanHalfNum_Solution(arr));
    }
}
