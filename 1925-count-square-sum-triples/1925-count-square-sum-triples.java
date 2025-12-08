class Solution {
    public int countTriples(int n) {
        // Step 1: Precompute squares
        HashSet<Integer> squares = new HashSet<>(); 
        for (int i = 1; i <= n; i++) squares.add(i * i);
        int count = 0;

        // Step 2: Check all pairs (a, b)
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = a * a + b * b;
                if (squares.contains(sum)) {
                    count++;
                }
            }
        }
        return count;
    }
}