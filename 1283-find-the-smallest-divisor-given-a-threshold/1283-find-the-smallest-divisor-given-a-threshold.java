class Solution {
    int findSum(int mid, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (int) Math.ceil((double) nums[i] / mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maximum) {
                maximum = nums[i];
            }
        }

        int left = 1, right = maximum;
        int sum, divisor = maximum; 

        while (left <= right) {
            int mid = left + (right - left) / 2;
            sum = findSum(mid, nums);
            if (sum <= threshold) {
                // divisor = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
