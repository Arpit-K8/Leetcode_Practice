class Trie {
    class TrieNode{
        TrieNode[] link;
        boolean isEnd;
        public TrieNode(){
            link = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(temp.link[idx] == null) temp.link[idx] = new TrieNode();
            temp = temp.link[idx];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(temp.link[idx] == null) return false;
            temp = temp.link[idx];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch-'a';
            if(temp.link[idx] == null) return false;  
            temp = temp.link[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */