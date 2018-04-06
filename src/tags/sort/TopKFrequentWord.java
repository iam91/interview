package tags.sort;

import java.util.*;

public class TopKFrequentWord {
    // https://leetcode.com/problems/top-k-frequent-words/description/

    class TrieNode {

        char ch;
        String word;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char ch) {
            this.ch = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    private void addWord(String word, TrieNode root) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new TrieNode(ch);
            }
            root = root.children[ch - 'a'];
        }
        root.isEnd = true;
        root.word = word;
    }

    private void getWord(List<String> words, TrieNode root, int n) {
        if(root == null) return;
        if(words.size() == n) return;

        if(root.isEnd) {
            words.add(root.word);
        }
        for(int i = 0; i < 26; i++) {
            getWord(words, root.children[i], n);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // return priorityQueue(words, k);
        return bucketSort(words, k);
    }

    private List<String> bucketSort(String[] words, int k) {
        HashMap<String, Integer> cnt = count(words);

        TrieNode[] bucket = new TrieNode[words.length + 1];

        for(Map.Entry<String, Integer> entry: cnt.entrySet()) {
            TrieNode curr = bucket[entry.getValue()];
            if(curr == null) curr = bucket[entry.getValue()] = new TrieNode('0');
            curr.isEnd = false;
            addWord(entry.getKey(), curr);
        }

        List<String> ret = new LinkedList<>();
        for(int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
            if(bucket[i] != null) {
                getWord(ret, bucket[i], k);
            }
        }

        return ret;
    }

    private List<String> priorityQueue(String[] words, int k) {
        HashMap<String, Integer> cnt = count(words);

        Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()) return o1.getValue() - o2.getValue();
                else return o2.getKey().compareTo(o1.getKey());
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(comp);

        for(Map.Entry<String, Integer> entry: cnt.entrySet()) {
            if(heap.size() < k) {
                heap.add(entry);
            } else {
                if(comp.compare(entry, heap.peek()) > 0) {
                    heap.poll();
                    heap.add(entry);
                }
            }
        }

        LinkedList<String> ret = new LinkedList<>();
        while(!heap.isEmpty()) {
            ret.addFirst(heap.poll().getKey());
        }

        return ret;
    }

    private HashMap<String, Integer> count(String[] words) {
        HashMap<String, Integer> cnt = new HashMap<>();

        for(String w: words) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        TopKFrequentWord c = new TopKFrequentWord();

        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        System.out.println(c.topKFrequent(words, k));
    }
}
