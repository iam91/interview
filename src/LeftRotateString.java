public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        int len = str.length();
        n = n % len;
        StringBuilder s = new StringBuilder();

        int i = 0;
        while(i < n) i++;
        while(i < len) {
            s.append(str.charAt(i++));
        }
        i = 0;
        while(i < n) {
            s.append(str.charAt(i++));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LeftRotateString c = new LeftRotateString();
        System.out.printf(c.LeftRotateString("abcXYZdef", 12));
    }
}
