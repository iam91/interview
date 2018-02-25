import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {

        if(numbers == null) return "";
        int n = numbers.length;
        if(n == 0) return "";

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nums.add(numbers[i]);
        }

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder ret = new StringBuilder();
        for(Integer nn: nums) ret.append(String.valueOf(nn));

        return ret.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber c = new PrintMinNumber();

        int[] arr = {3,32,321};
        System.out.println(c.PrintMinNumber(arr));
    }
}
