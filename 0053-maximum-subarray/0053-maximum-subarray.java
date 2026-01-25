class Solution {
    public int maxSubArray(int[] nums) {
        // int sum = 0,max = Integer.MIN_VALUE; 
        // for(int num :nums){
        //     if(sum<0){
        //         sum=0;
        //     }
        //     sum+=num;
        //     max = Math.max(sum,max);
        // }
        // return max;

        int sum     = nums[0];
        int maxSum  = nums[0];
        for(int i = 1; i<nums.length; i++) {
            sum     = Math.max(sum + nums[i], nums[i]);
            maxSum  = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}