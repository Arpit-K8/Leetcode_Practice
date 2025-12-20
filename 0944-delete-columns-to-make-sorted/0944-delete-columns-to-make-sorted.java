class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int is = strs.length;
        int js = strs[0].length();
        for (int j = 0; j < js; j++) {
            for (int i = 1; i < is; i++) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}