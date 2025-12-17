class WordDictionary {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) { // for . scenario
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int pos, TrieNode node) {
        if (node == null) return false;
        if (pos == word.length()) return node.isEndOfWord;

        char ch = word.charAt(pos);
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfsSearch(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch - 'a';
            return dfsSearch(word, pos + 1, node.children[index]);
        }
    }
}