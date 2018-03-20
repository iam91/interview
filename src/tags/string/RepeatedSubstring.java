package tags.string;

public class RepeatedSubstring {
    // https://leetcode.com/problems/repeated-substring-pattern/description/

    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() < 2) return false;

        int n = s.length();
        int[] next = new int[n + 1];
        next[0] = -1;
        int k = -1;
        int i;
        for(i = 1; i <= n; i++) {
            while(k >= 0 && s.charAt(k) != s.charAt(i - 1)) {
                k = next[k];
            }
            next[i] = ++k;
        }
        i--; // rectify
        int atom = i - next[i];
        if(next[i] > 0 && next[i] % atom == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        RepeatedSubstring c = new RepeatedSubstring();
        System.out.println(c.repeatedSubstringPattern("abaabaa"));
    }
}
