class Solution { // Kadane algorithm
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            // If sum becomes negative, reset it to 0
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}