package leetcode.string;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0) return true;
        else if(t.length() == 0) return false;

        int n = s.length();
        int m = t.length();
        if(n > m) return false;

        int i = 0, j = 0;
        while(j < m) {
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
            if(i == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence c = new IsSubsequence();
        System.out.println(c.isSubsequence("abc", "ahbgdc"));
    }
}
