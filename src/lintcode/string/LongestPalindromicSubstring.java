package lintcode.string;

public class LongestPalindromicSubstring {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) return s;

        int n = s.length();
        int max = 0;
        String ret = "";
        String t;
        for(int i = 0; i < n; i++) {
            t = extend(s, i, i);
            if(t.length() > max) {
                max = t.length();
                ret = t;
            }

            t = extend(s, i, i + 1);
            if(t.length() > max) {
                max = t.length();
                ret = t;
            }
        }

        return ret;
    }

    private String extend(String s, int p, int q) {
        while(p >= 0 && q < s.length()) {
            if(s.charAt(p) == s.charAt(q)) {
                p--; q++;
            } else break;
        }
        return s.substring(p + 1, q);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring c = new LongestPalindromicSubstring();
        System.out.println("\"" + c.longestPalindrome("zbb") + "\"");
    }
}
