import java.util.Arrays;
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {

        if(numbers == null || numbers.length == 0) return false;

        Arrays.sort(numbers);
        int idx = 0;

        while(numbers[idx] == 0) {
            idx++;
        }
        int zeros = idx;

        int expect = numbers[idx];
        for(int i = idx; i < numbers.length; i++) {
            int t = numbers[i];
            if(t > expect) {
                if(t - expect > zeros) return false;
                else {
                    zeros -= (t - expect);
                    expect = t;
                }
            } else if(t < expect) {
                return false;
            }
            expect++;
        }

        return true;
    }

    public static void main(String[] args) {
        IsContinuous c = new IsContinuous();

        int[] arr = {1,3,0,5,0};

        System.out.println(c.isContinuous(arr));
    }
}
