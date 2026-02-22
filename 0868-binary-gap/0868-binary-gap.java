class Solution {
    public int binaryGap(int n) {
        String bits = Integer.toBinaryString(n);
        int max = 0,prev = -1;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                if (prev != -1) max = Math.max(max, i - prev);
                prev = i;
            }
        }
        return max;
    }
}