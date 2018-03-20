package tags.string;

// https://web.stanford.edu/class/cs97si/10-string-algorithms.pdf

public class Strstr {
    // https://leetcode.com/problems/implement-strstr/description/
    public int strStr(String haystack, String needle) {
//        return brutal(haystack, needle);
        return kmp(haystack, needle);
    }

    private int kmp(String s, String p) {

        if(s == null || p == null) return -1;
        if(p.length() == 0) return 0;
        if(s.length() == 0) return -1;

        int n = s.length();
        int m = p.length();

        // pre-process
        int[] next = new int[m + 1];
        next[0] = -1;
        int k = -1;
        for(int i = 1; i <= m; i++) {
            while(k >= 0 && p.charAt(k) != p.charAt(i - 1)) {
                k = next[k];
            }
            next[i] = ++k;
        }

        // pattern match
        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j >= 0 && p.charAt(j) != s.charAt(i - 1)) {
                j = next[j];
            }
            j++;
            if(j == m) {
                return i - m;
            }
        }

        return -1;
    }

    public int brutal(String s, String p) {
        if(s == null || p == null) return -1;
        if(p.length() == 0) return 0;
        if(s.length() == 0) return -1;

        int n = s.length();
        int m = p.length();

        for(int i = 0; i < n; i++) {
            int j;
            for(j = 0; j < m && i + j < n; j++) {
                if(s.charAt(i + j) != p.charAt(j)) break;
            }
            if(j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Strstr c = new Strstr();
        System.out.println(c.strStr("hello", "ll"));
    }
}
