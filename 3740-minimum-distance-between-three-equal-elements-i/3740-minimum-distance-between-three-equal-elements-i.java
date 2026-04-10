class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Store indices
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int minDist = Integer.MAX_VALUE;
        // Check each number's index list
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            for (int i = 0; i < list.size() - 2; i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}