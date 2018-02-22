public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;

        if(array.length == 0) return 0;

        int left = 0, right = len - 1;
        int mid = (left + right) / 2;

        while(left < mid) {


            if(array[mid] <= array[right] && array[mid] <= array[left]) {
                right = mid;
            } else if(array[mid] >= array[left] && array[mid] >= array[right]) {
                left = mid;
            } else if(array[mid] <= array[right] && array[mid] >= array[left]) {
                right = left;
            }

            mid = (left + right) / 2;
        }


        return array[right];
    }

    public static void main(String[] args) {

        MinNumberInRotateArray c = new MinNumberInRotateArray();

//        int[] num = {3,4,5,1,2};
        int[] num = {2,3,4,5,2};
        System.out.println(c.minNumberInRotateArray(num));
    }
}
