package tags.string;

public class RepeatedStringMatch {
    // https://leetcode.com/problems/repeated-string-match/description/
    public int repeatedStringMatch(String A, String B) {
        int n = A.length();
        int m = B.length();

        StringBuilder s = new StringBuilder(A);
        int k = m / n;
        for(int i = 0; i < k - 1; i++) {
            s = s.append(A);
        }
        if(k == 0) k++;

        int cnt = 0;
        do {
            if(kmp(s.toString(), B) >= 0) {
                return k;
            }
            s = s.append(A);
            k++;
            cnt++;
        } while(cnt <= 2);
        return -1;
    }

    private int kmp(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[] next = new int[m + 1];
        next[0] = -1;
        int k = -1;
        for(int i = 1; i <= m; i++) {
            while(k >= 0 && p.charAt(k) != p.charAt(i - 1)) {
                k = next[k];
            }
            next[i] = ++k;
        }

        k = 0;
        for(int i = 1; i <= n; i++) {
            while(k >= 0 && p.charAt(k) != s.charAt(i - 1)) {
                k = next[k];
            }
            k++;
            if(k == m) return i - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch c = new RepeatedStringMatch();
        System.out.println(c.repeatedStringMatch("abababaaba", "aabaaba"));
//        System.out.println(c.kmp("abababaaba", "aabaaba"));
        System.out.println(c.repeatedStringMatch("bb", "bbbbbbbb"));
    }
}
