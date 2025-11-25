class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        long remain = 0;
        int l = 0;
        for (int i = 1; i <= k; i++){
            remain = (remain * 10 + 1) % k;
            l++;
            if (remain == 0){
                return l;
            }
        }
        return l;
    }
}