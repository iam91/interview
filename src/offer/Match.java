package offer;

public class Match {
//    public boolean match(char[] str, char[] pattern)
//    {
//        int idx = 0;
//        int star = -1;
//        for(int i = 0; i < pattern.length; i++) {
//            char pat = pattern[i];
//            if(pat == '.') {
//                if(star != -1) star = -1;
//                idx++;
//            } else if(pat == '*') {
//
//                if(i > 0) {
//                    char t = pattern[i - 1];
//                    if(t != '.') {
//                        star = idx - 1;
//                        while(idx < str.length && str[idx] == 't') {
//                            idx++;
//                        }
//                    }
//                }
//            } else {
//                if(pat != str[idx]) {
//
//                    if(pattern[i + 1] == '*') {
//                        i++;
//                    } else {
//
//                        if(star == -1) {
//                            return false;
//                        } else {
//                            while(idx >= star) {
//                                if(str[idx] == pat) {
//                                    idx++;
//                                    break;
//                                } else {
//                                    idx--;
//                                }
//                            }
//                            if(idx < star) return false;
//                        }
//                    }
//                } else {
//                    idx++;
//                    if(star != -1) star = -1;
//                }
//            }
//        }
//
//        if(idx == str.length) return true;
//        else return false;
//    }

    public boolean match(char[] str, char[] pattern) {

        return match(str, pattern, 0, 0);
    }

    public boolean match(char[] str, char[] pattern, int s, int p) {

        if(p == pattern.length) {
            if(s == str.length) {
                return true;
            } else {
                return false;
            }
        }

        if(p + 1 < pattern.length && pattern[p + 1] == '*') {
            if(s < str.length && (str[s] == pattern[p] || (pattern[p] == '.' && s < str.length))) {
                return match(str, pattern, s + 1, p + 2)
                        || match(str, pattern, s + 1, p)
                        || match(str, pattern, s, p + 2);
            } else {
                return match(str, pattern, s, p + 2);
            }
        }

        if(s < str.length && str[s] == pattern[p] || (pattern[p] == '.' && s < str.length)) {
            return match(str, pattern, s + 1, p + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Match c = new Match();
        char[] s = "".toCharArray();
        char[] p = ".".toCharArray();
        System.out.println(c.match(s, p));
    }
}