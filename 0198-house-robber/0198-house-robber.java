// class Solution {
//     public int rob(int[] arr) {
//         int n = arr.length;
//         if(arr.length == 1) return arr[0];
//         int[] dp = new int[n];
//         dp[0] = arr[0];
//         int max = Math.max(arr[0],arr[1]);
//         dp[1] = max;
//         for(int i = 2; i<n ; i++){
//             max = Math.max(dp[i-2]+arr[i],dp[i-1]);
//             dp[i] = max;
//         }
//         return max;
//     }
// }
class Solution {
    int[] dp;
    public int rob(int[] arr) {
        int n = arr.length;
        dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,n);
    }
    public int solve(int[] arr, int i, int n){
      if(i>=n) return 0;
      
      if(dp[i]!=-1) return dp[i];
      
      int steal = arr[i] + solve(arr,i+2,n);
      int skip = solve(arr,i+1,n);
      return dp[i] = Math.max(steal,skip);
    }
}