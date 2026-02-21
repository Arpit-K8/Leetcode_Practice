class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0,count = 0;
        for (int i = left; i <= right; i++) {
           // int setBits = Integer.bitCount(i);  // counts 1s in binary // builtin java function
            String digit = Integer.toBinaryString(i);
            for(char ch : digit.toCharArray()){
                if(ch=='1') count++;
            }
            if (isPrime(count)) result++;
            count = 0;
        }
        return result;
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}