class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int len = 1;

            Integer key = mp.lowerKey(nums[i]);
            if (key != null) {
                len += mp.get(key);
            }

            mp.put(nums[i], Math.max(mp.getOrDefault(nums[i], 0), len));

            key = mp.higherKey(nums[i]);
            while (key != null && mp.get(key) <= len) {
                mp.remove(key);
                key = mp.higherKey(nums[i]);
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}