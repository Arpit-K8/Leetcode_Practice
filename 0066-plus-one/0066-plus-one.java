class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0; // carry over
        }
        // If all digits were 9, we need a new array
        int[] result = new int[n + 1];
        result[0] = 1; // e.g., [9,9] → [1,0,0]
        return result;
    }
}