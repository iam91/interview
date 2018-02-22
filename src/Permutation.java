import java.util.ArrayList;
import java.util.Collections;

public class Permutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList();
        if(str == null || str.length() == 0) return res;

        char[] chs = str.toCharArray();

        perm(res, chs, 0);
        Collections.sort(res);

        return res;
    }

    private void perm(ArrayList<String> res, char[] str, int start) {
        if(start == str.length - 1) {
            String s = String.valueOf(str);
            res.add(s);
        }

        for(int i = start; i < str.length; i++) {
            if(needSwap(str, start, i)) {
                swap(str, start, i);
                perm(res, str, start + 1);
                swap(str, start, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private boolean needSwap(char[] arr, int i, int j) {
        for(int k = i; k < j; k++) {
            if(arr[k] == arr[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Permutation c = new Permutation();
        ArrayList<String> ss = c.Permutation("abb");
        for(String s: ss) {
            System.out.println(s);
        }
    }
}