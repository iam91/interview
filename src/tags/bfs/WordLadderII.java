package tags.bfs;

import java.util.*;

public class WordLadderII {
    // https://leetcode.com/problems/word-ladder-ii/description/

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ret = new LinkedList<>();

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> graph = new HashMap<>();

        Queue<String> q = new LinkedList<>();

        for(String s: wordList) {
            graph.put(s, new HashSet<>());
        }
        graph.put(beginWord, new HashSet<>());

        q.offer(beginWord);

        boolean found = false;
        int len = 0;
        while(!q.isEmpty() && !found) {
            int size = q.size();

            len++;
            Set<String> set = new HashSet<>();
            for(int i = 0; i < size; i++) {
                String curr = q.poll();

                if(!found && curr.equals(endWord)) { found = true; }

                for(String s: next(curr, wordSet)) {
                    if(!visited.contains(s)) {
                        set.add(s);
                        q.offer(s);
                        graph.get(curr).add(s);
                    }
                }
            }
            visited.addAll(set);
        }

        Set<String> pathSet = new HashSet<>();
        List<String> path = new LinkedList<>();

        path.add(beginWord);
        pathSet.add(beginWord);
        getPaths(ret, path, pathSet, graph, beginWord, endWord, 1, len);

        return ret;
    }

    private void getPaths(List<List<String>> paths,
                          List<String> path,
                          Set<String> pathSet,
                          Map<String, Set<String>> graph,
                          String curr, String endWord, int deep, int len) {
        if(deep > len) return;
        if(endWord.equals(curr)) {
            paths.add(new LinkedList<>(path));
        } else {
            for(String next: graph.get(curr)) {
                if(!pathSet.contains(next)) {
                    path.add(next);
                    pathSet.add(next);

                    getPaths(paths, path, pathSet, graph, next, endWord, deep + 1, len);

                    path.remove(next);
                    pathSet.remove(next);
                }
            }
        }
    }

    private List<String> next(String str, Set<String> wordSet) {

        List<String> words = new ArrayList<>();

        StringBuilder cand = new StringBuilder(str);
        String candi;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for(char c = 'a'; c <= 'z'; c++) {
                if(ch != c) {
                    cand.setCharAt(i, c);
                    candi = cand.toString();
                    if(wordSet.contains(candi)) {
                        words.add(candi);
                    }
                }
            }
            cand.setCharAt(i, ch);
        }

        return words;
    }

    public static void main(String[] args) {
        WordLadderII c = new WordLadderII();
        String[] words = {
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };
        List<String> wordList = new LinkedList<>();
        for(String s: words) wordList.add(s);
        System.out.println(c.findLadders("cet", "ism", wordList));
    }
}
