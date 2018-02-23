import java.util.ArrayList;
import java.util.Collections;
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int sumDouble = 2 * sum;
        int lim = (int)Math.sqrt(sumDouble);

        for(int n = 2; n <= lim; n++) {
            boolean flag = sumDouble % n == 0 && (sumDouble / n - (n - 1)) % 2 == 0;
            if(flag) {
                ArrayList<Integer> seq = new ArrayList<>();
                int head = sum / n - (n - 1) / 2;
                int tail = head + (n - 1);
                int curr = head;
                while(curr <= tail) seq.add(curr++);
                ret.add(seq);
            }
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        FindContinuousSequence c = new FindContinuousSequence();
        for(ArrayList<Integer> seq: c.FindContinuousSequence(50)) {
            for(Integer i: seq) {
                System.out.print(
                        i + " "
                );
            }
            System.out.println();
        }
    }
}
