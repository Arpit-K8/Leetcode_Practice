class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);  // counts 1s in binary // builtin java function
            if (isPrime(bits)) cnt++;
        }
        return cnt;
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}