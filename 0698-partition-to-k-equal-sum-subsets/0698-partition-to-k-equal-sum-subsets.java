class Solution {
    int partitionSum = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        // If total sum is not divisible by k, not possible
        if (totalSum % k != 0) return false;
        partitionSum = totalSum / k;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, k, 0, 0);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int currentSum, int startIndex) {
        // If only one bucket left, it must be valid
        if (k == 1) return true;
        // If current bucket reached target, start filling next bucket
        if (currentSum == partitionSum) {
            return backtrack(nums, visited, k - 1, 0, 0);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i]) continue;
            if (currentSum + nums[i] > partitionSum) continue;
            visited[i] = true;
            if (backtrack(nums, visited, k, currentSum + nums[i], i + 1)) return true;
            visited[i] = false; // backtrack
            // Pruning: if currentSum is 0 and first element fails, no need to try others
            if (currentSum == 0) return false;
        }
        return false;
    }
}
