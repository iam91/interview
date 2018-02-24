import java.util.ArrayList;
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(array == null || array.length == 0) return ret;

        int l = 0, r = array.length - 1;
        while(l < r) {
            int s = array[l] + array[r];
            if(s == sum) {
                ret.add(array[l]);
                ret.add(array[r]);
                break;
            } else if(s > sum) {
                r--;
            } else {
                l++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        FindNumbersWithSum c = new FindNumbersWithSum();

        int[] arr = {-1, 2, 2, 3, 5};

        System.out.println(c.FindNumbersWithSum(arr, 4));
    }
}
