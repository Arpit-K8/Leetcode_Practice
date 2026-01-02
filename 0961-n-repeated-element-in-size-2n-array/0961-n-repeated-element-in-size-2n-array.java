class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() == max) {
                res = e.getKey();
                break;
            }
        }
        return res;
    }
}