class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += factors(num);
        return sum;
    }
    private int factors(int n) {
        int sum = 0, count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;
                // If it's a square or already found more than one pair, not valid
                if (j == i || count > 0) return 0;
                sum += i + j;
                count++;
            }
        }
        if (count == 0) return 0; // If no divisor pair found, return 0
        return 1 + sum + n;  // Add 1 and n itself (the trivial divisors)
    }
}