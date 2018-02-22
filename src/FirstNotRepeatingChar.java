public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {

        if(str == null || str.equals("")) return -1;

        int[] c = new int['z' - 'A' + 1];
        int[] i = new int['z' - 'A' + 1];

        for(int k = 0; k < c.length; k++) {
            c[k] = 0;
        }

        for(int k = 0; k < str.length(); k++) {
            char ch = str.charAt(k);
            c[ch - 'A']++;
            i[ch - 'A'] = k;
        }


        int k = 0;
        while(k < c.length && c[k] != 1) {
            k++;
        }

        if(k >= c.length) return -1;

        int ii = i[k];
        for(int kk = k; kk < c.length; kk++) {
            if(c[kk] == 1 && i[kk] < ii) {
                ii = i[kk];
            }
        }

        return ii;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar c = new FirstNotRepeatingChar();
        System.out.println(c.FirstNotRepeatingChar(""));
    }
}
