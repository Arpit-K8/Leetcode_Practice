class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reached = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= reached) {
                reached = i; // Shift the target to the curernt index
            }
        }
        return reached == 0;
    }
}