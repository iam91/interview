public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.trim().equals("")) return str;

        String[] ss = str.split(" ");
        StringBuilder ret = new StringBuilder();
        for(int i = ss.length - 1; i >= 0; i--) {
            ret.append(ss[i]);
            ret.append(i > 0 ? " ": "");
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        ReverseSentence c = new ReverseSentence();
        String s = "student. a am I";
        String r;
        System.out.println(r = c.ReverseSentence(s));

    }
}
