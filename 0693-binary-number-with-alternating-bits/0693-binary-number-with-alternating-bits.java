class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 1; i < binary.length(); i++) {
            char curr = binary.charAt(i);
            char prev = binary.charAt(i - 1);
            if (curr == prev) return false;
        }
        return true;
    }
}