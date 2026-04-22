class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // HashMap to store cumulative sums and their frequencies
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int currSum = 0;
        mp.put(0, 1);
        for (int num : nums) {
            currSum += num;
            if (mp.containsKey(currSum - k)) count += mp.get(currSum - k);
            mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}