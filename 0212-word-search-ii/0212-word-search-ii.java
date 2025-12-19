class Solution {
    class TrieNode {
        boolean endOfWord;
        char ch;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode getNode() {
        TrieNode newNode = new TrieNode();
        newNode.endOfWord = false;
        newNode.ch = ' ';
        return newNode;
    }

    private void insert(TrieNode root, String word) {
        TrieNode pCrawl = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = getNode();
                pCrawl.children[idx].ch = ch;
            }
            pCrawl = pCrawl.children[idx];
        }
        pCrawl.endOfWord = true;
    }

    private int m, n;
    private List<String> result = new ArrayList<>();
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private void dfs(char[][] board, int i, int j, TrieNode root, StringBuilder sb) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        char ch = board[i][j];
        if (ch == '$') return;

        int idx = ch - 'a';
        if (root.children[idx] == null) return;

        root = root.children[idx];
        sb.append(ch);

        if (root.endOfWord) {
            result.add(sb.toString());
            root.endOfWord = false; // avoid duplicates
        }

        board[i][j] = '$'; // mark visited
        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1], root, sb);
        }
        board[i][j] = ch; // restore
        sb.deleteCharAt(sb.length() - 1); // backtrack
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        TrieNode root = getNode();
        for (String word : words) {
            insert(root, word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = board[i][j] - 'a';
                if (root.children[idx] != null) {
                    dfs(board, i, j, root, new StringBuilder());
                }
            }
        }

        return result;
    }
}