import java.util.Arrays;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {

        if(numbers == null) return "";
        int n = numbers.length;
        if(n == 0) return "";

        String[] nums = new String[n];
        for(int i = 0; i < n; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums);

        return "";
    }

    public static void main(String[] args) {
        PrintMinNumber c = new PrintMinNumber();

        int[] arr = {3,32,321};
        System.out.println(c.PrintMinNumber(arr));
    }
}
