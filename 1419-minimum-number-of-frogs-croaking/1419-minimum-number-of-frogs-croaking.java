class Solution {
    private int getIndex(char ch) {
        switch (ch) {
            case 'c': return 0;
            case 'r': return 1;
            case 'o': return 2;
            case 'a': return 3;
            case 'k': return 4;
            default: return -1;
        }
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // c, r, o, a, k
        int frogs = 0, maxFrogs = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            int idx = getIndex(ch);
            if (idx == -1) return -1;
            count[idx]++;
            // Validate sequence
            if (idx > 0 && count[idx] > count[idx - 1]) return -1;

            if (ch == 'c') {
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            } else if (ch == 'k') {
                // One frog finishes croaking
                for (int i = 0; i < 5; i++) count[i]--;
                frogs--;
            }
        }
        // All counts must be zero at the end
        for (int c : count) {
            if (c != 0) return -1;
        }
        return maxFrogs;
    }
}