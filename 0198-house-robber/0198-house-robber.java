class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(arr.length == 1) return arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = Math.max(arr[0],arr[1]);
        dp[1] = max;
        for(int i = 2; i<n ; i++){
            max = Math.max(dp[i-2]+arr[i],dp[i-1]);
            dp[i] = max;
        }
        return max;
    }
}