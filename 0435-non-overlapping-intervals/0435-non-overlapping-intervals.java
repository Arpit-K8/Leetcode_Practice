class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        int count = 1, last = nums[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] >= last) {
                count++;
                last = nums[i][1];
            }
        }
        return nums.length - count;
    }
}