class Solution {
    // Length of Sₙ = 2ⁿ - 1
    private int len(int n) {
        return (1 << n) - 1; //equivalent to Math.pow(2,n) - 1
    }
    // Flips a binary character
    private char flipBit(char x) {
        return x == '1' ? '0' : '1';
    }
    // Mirror index transformation
    private int mirrorIndex(int prevLen, int k) {
        return 2 * prevLen + 2 - k;
    }
    public char findKthBit(int n, int k) {
        // Base case: S₁ = "0"
        if (n == 1) return '0';
        int prevLen = len(n - 1);
        // Case 1: Middle element
        if (k == prevLen + 1) return '1';
        // Case 2: Right half
        if (k > prevLen + 1) return flipBit(findKthBit(n - 1, mirrorIndex(prevLen, k)));
        // Case 3: Left half
        return findKthBit(n - 1, k);
    }
}