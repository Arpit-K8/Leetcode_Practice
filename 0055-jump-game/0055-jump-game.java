class Solution {
    // public boolean canJump(int[] nums) {
    //     int n = nums.length;
    //     int reached = n - 1;
    //     for (int i = n - 2; i >= 0; i--) {
    //         if (i + nums[i] >= reached) {
    //             reached = i; // Shift the target to the curernt index
    //         }
    //     }
    //     return reached == 0;
    // }
    //Sir's method
    
    public boolean canJump(int[] arr) {
    int range = 0;
    for (int i = 0; i < arr.length; i++) {
        if (i > range) return false;
        range = Math.max(range, arr[i] + i);
        if (range >= arr.length - 1) return true;
    }
    return true;
    }
}