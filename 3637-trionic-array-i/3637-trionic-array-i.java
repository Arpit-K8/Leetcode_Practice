class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;  // minimum length needed
        int i = 1;
        while (i < n && nums[i] > nums[i - 1]) { // Strictly inc
            i++;
        }
        
        // p must exist
        if (i == 1 || i == n) return false;
        int decStart = i;  // strictly dec
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }

        // q must exist
        if (i == decStart || i == n) return false;
        while (i < n && nums[i] > nums[i - 1]) { // strictly imc
            i++;
        }
        return i == n;
    }
}
