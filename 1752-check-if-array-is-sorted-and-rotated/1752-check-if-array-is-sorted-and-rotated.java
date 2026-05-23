class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        // Check non-decreasing violations
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) count++;
        }

        // Check circular condition
        if (nums[n - 1] > nums[0]) count++;
        // Valid if at most one violation
        return count <= 1;
    }
}