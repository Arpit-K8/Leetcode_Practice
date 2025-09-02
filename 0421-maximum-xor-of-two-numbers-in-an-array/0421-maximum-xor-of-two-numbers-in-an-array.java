class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 0 and 1
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }

    private int findMaxXor(TrieNode root, int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] arr) {
        TrieNode root = new TrieNode();
        for (int num : arr) {
            insert(root, num);
        }

        int max = 0;
        for (int num : arr) {
            max = Math.max(max, findMaxXor(root, num));
        }
        return max;
    }
}