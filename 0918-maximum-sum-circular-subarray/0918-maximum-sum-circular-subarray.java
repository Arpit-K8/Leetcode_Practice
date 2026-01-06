class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int SUM = 0;
        for (int num : nums) SUM += num;
        int minSum = KadaneMin(nums, n);
        int maxSum = KadaneMax(nums, n); 
        int circSum = SUM - minSum;
        /* If all numbers are negative, circSum becomes 0 (invalid), so return
         maxSum directly. Otherwise, take the max of normal and circular cases.*/
        if (maxSum > 0) {
            return Math.max(maxSum, circSum);
        }
        return maxSum;
    }
    private int KadaneMax(int[] arr, int n){
        int sum = arr[0], max = arr[0];
        for(int i = 1;i<n;i++){
            sum = Math.max(sum+arr[i],arr[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
    private int KadaneMin(int[] arr, int n){
        int sum = arr[0], min = arr[0];
        for(int i = 1;i<n;i++){
            sum = Math.min(sum+arr[i],arr[i]);
            min = Math.min(min,sum);
        }
        return min;
    }
}