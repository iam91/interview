package leetcode.string;

public class LenOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();

        int[] dict = new int[256];
        int[] d = new int[n];

        d[0] = 1;
        dict[s.charAt(0) - '\0'] = 1;
        int max = 1;
        for(int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if(dict[c - '\0'] == 0) {
                d[i] = d[i - 1] + 1;
            }
            else {
                int old = dict[c - '\0'];
                d[i] = i + 1 - old;
                for(int j = 0; j < 256; j++) {
                    if(dict[j] < old) dict[j] = 0;
                }
            }
            dict[c - '\0'] = i + 1;
            if(d[i] > max) max = d[i];
        }

        return max;
    }

    public static void main(String[] args) {
        LenOfLongestSubstring c = new LenOfLongestSubstring();
        System.out.println(c.lengthOfLongestSubstring("abba"));
    }
}
