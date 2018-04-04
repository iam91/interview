package tags.trie;

class Trie {

    // https://leetcode.com/problems/implement-trie-prefix-tree/description/

    class TrieNode {
        char ch;
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;

        TrieNode (char ch) {
            this.ch = ch;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}
