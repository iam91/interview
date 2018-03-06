package offer;

public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int i = 0;
        while(i < str.length()) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(i, '%');
                str.insert(i + 1, '2');
                str.insert(i + 2, '0');
            }
            i ++;
        }
        return str.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        StringBuffer st = new StringBuffer();

        int len = str.length();
        for(int i = 0; i < len; i++) {
            char t = str.charAt(i);
            if(t == ' ') {
                st.append("%20");
            } else {
                st.append(t);
            }
        }

        return st.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace c = new ReplaceSpace();
        String s = c.replaceSpace1(new StringBuffer("We Are Happy"));
        System.out.println(s);
    }
}
