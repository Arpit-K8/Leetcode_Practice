class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if(square == x) return (int)mid;
            else if(square < x ){
                ans = (int) mid;
                left = mid+1;
            } 
            else right = mid-1;
        }
        return ans;
    }
}