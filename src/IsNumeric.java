public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if(str.length < 1) return false;

        int start = 0;

        //check sign
        if(str[0] == '-' || str[0] == '+') {
            start = 1;
        } else if(Character.isDigit(str[0])) {
            start = 0;
        } else {
            return false;
        }

        boolean decimal = false;
        boolean exp = false;
        boolean signOfExp = false;
        char ch;
        for(int i = start; i < str.length; i++) {
            ch = str[i];
            if(ch == '.') {
                if(decimal || exp) {
                    return false;
                }
                decimal = true;
            } else if(ch == 'e' || ch == 'E') {
                if(exp) {
                    return false;
                }
                exp = true;
                if(i == str.length - 1) return false;
                char t = str[i + 1];
//                if(t != '-' || t != '+' || !Character.isDigit(t)) return false;
                if(t == '-' || t == '+' || Character.isDigit(t)) i++;
                else return false;
            } else if(!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsNumeric c = new IsNumeric();

        char[] in = "123.45e+6".toCharArray();
        System.out.println(c.isNumeric(in));
    }
}