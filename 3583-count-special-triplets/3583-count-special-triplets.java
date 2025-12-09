class Solution {
    static final int M = (int)1e9 + 7;
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> mpLeft = new HashMap<>();
        Map<Integer, Integer> mpRight = new HashMap<>();
        int result = 0;
        // Fill mpRight with frequencies
        for (int num : nums) {
            mpRight.put(num, mpRight.getOrDefault(num, 0) + 1);
        }
        // Traverse again
        for (int num : nums) {
            // Reduce count from right map
            mpRight.put(num, mpRight.get(num) - 1);

            int left  = mpLeft.getOrDefault(num * 2, 0);
            int right = mpRight.getOrDefault(num * 2, 0);
            long add = (1L * left * right) % M;
            result = (int)((result + add) % M);
            mpLeft.put(num, mpLeft.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
