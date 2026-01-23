class Solution {
    public int[] productExceptSelf(int[] nums) { // [1,2,3,4]
        int[] left = new int[nums.length]; // [0 0 0 0]
        int[] right = new int[nums.length];

        left[0] = 1; // [1 0 0 0]
        for (int i = 1; i < nums.length; i++) { 
            left[i] = left[i - 1] * nums[i - 1]; // [1,1,2,6]
        }
        right[nums.length - 1] = 1;// [0 0 0 1]
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1]; // [24,12,4,1]
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i]; // [24,12,8,6]
        }
        return ans;
    }
}