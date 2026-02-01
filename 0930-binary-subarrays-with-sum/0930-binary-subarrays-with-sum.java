class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int countZeros = 0;
        int windowSum = 0,count = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            windowSum += nums[j];
            while (i < j && (nums[i] == 0 || windowSum > goal)) {
                if (nums[i] == 1) countZeros = 0;
                else countZeros += 1;
                
                windowSum -= nums[i];
                i++;
            }
            if (windowSum == goal) {
                count += 1 + countZeros;
            }
            j++;
        }
        return count;
    }
}