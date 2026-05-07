class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;
        // for (int i = 1; i < n; i++) {
		// 	// Swapping min and max
        //     if (nums[i] < 0){
        //         int temp = max;
        //         max = min;
        //         min = temp;
        //     }
        //     max = Math.max(nums[i], max * nums[i]);
        //     min = Math.min(nums[i], min * nums[i]);
        //     ans = Math.max(ans, max);
        // }

        // one more approach
        for(int i =1;i<n;i++){
            int tempmax = max;
            max = Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i],Math.min(nums[i]*tempmax,nums[i]*min));
            ans = Math.max(max,ans);
        }
        return ans;
    }
}

/*
nums = [-2, 3, -4]

i=0: max = -2,  min = -2,  ans = -2

i=1: max = 3,   min = -6,  ans = 3
     (min=-6 seems useless right now...)

i=2: max = Math.max(-4, -4×3, -4×-6)
          = Math.max(-4, -12, 24)
          = 24 is the ans ← min=-6 saved us here!
 */