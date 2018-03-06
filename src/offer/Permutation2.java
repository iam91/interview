package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation2 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList();
        if(str == null || str.length() == 0) return res;

        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        res.add(String.valueOf(chs));

        while(true) {
            int i = chs.length - 1;
            while(i > 0 && chs[i] <= chs[i - 1]) i--;
            if(i == 0) break;

            int pivotIdx = i - 1;
            i = chs.length - 1;
            while(chs[i] <= chs[pivotIdx]) i--;
            swap(chs, pivotIdx, i);
            reverse(chs, pivotIdx + 1, chs.length - 1);

            res.add(String.valueOf(chs));
        }

        return res;
    }

    private void reverse(char[] arr, int i, int j) {
        for(int k = i; k < j; k++) {
            char t = arr[j];
            for(int l = j; l > k; l--) {
                arr[l] = arr[l - 1];
            }
            arr[k] = t;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Permutation2 c = new Permutation2();
        ArrayList<String> ss = c.Permutation("abb");
        for(String s: ss) {
            System.out.println(s);
        }
    }
}