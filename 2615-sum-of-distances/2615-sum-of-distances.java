class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        // group indices for eg. {1 -> [0,2,3]}
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            int size = list.size();
            long prefixSum = 0;
            for (int i = 0; i < size; i++) {
                int idx = list.get(i);
                res[idx] += (long) i * idx - prefixSum;
                prefixSum += idx;
            }
            long suffixSum = 0;
            for (int i = size - 1; i >= 0; i--) {
                int idx = list.get(i);
                res[idx] += suffixSum - (long) (size - 1 - i) * idx;
                suffixSum += idx;
            }
        }
        return res;
    }
}