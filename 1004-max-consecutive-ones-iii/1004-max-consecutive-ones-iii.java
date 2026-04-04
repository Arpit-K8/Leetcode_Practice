class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length,maxlen = 0;
        while (right < n) {
            if (nums[right] == 0) k--;
            // If flips exceeded, shrink window
            while (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}