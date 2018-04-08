package tags.bfs;

import java.util.*;

public class WordLadder {
    // https://leetcode.com/problems/word-ladder/description/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String s: wordList) {
            visited.put(s, false);
        }
        visited.put(beginWord, false);
        Set<String> wordSet = visited.keySet();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            len++;
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                if(curr.equals(endWord)) return len;
                for(String s: next(curr, wordSet)) {
                    if(!visited.get(s)) {
                        visited.put(s, true);
                        q.offer(s);
                    }
                }
            }
        }

        return 0;
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
        WordLadder c = new WordLadder();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new LinkedList<>();
        for(String s: words) wordList.add(s);
        System.out.println(c.ladderLength("hit", "cog", wordList));
    }
}
