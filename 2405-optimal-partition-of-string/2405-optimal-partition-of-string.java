class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int cnt = 1; // At least one partition

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                cnt++; // Start new partition
                seen = new boolean[26]; // Reset
            }
            seen[c - 'a'] = true;
        }

        return cnt;
    }
}