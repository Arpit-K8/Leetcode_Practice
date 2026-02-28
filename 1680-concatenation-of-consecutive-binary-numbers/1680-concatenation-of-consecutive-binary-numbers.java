class Solution {
    public int concatenatedBinary(int n) {
        int digit = 0;
        int MOD = 1_000_000_007;
        long res = 0;
        for(int i = 1; i <= n; i++){
            // power of 2 means req of digit space is increased// 2->01 (2), 8->1000 (4)
            if((i & (i - 1)) == 0) digit++; 
            res = ((res << digit) % MOD + i) % MOD;
        }
        return (int)res;
    }
}