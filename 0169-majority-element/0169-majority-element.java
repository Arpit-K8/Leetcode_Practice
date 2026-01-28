class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // As soon as we find a number > n/2, return it
            if (freq.get(num) > n / 2) {
                return num;
            }
        }

        // Problem guarantees majority element exists, so we’ll always return inside loop
        return -1; // fallback (not really needed)
    }
}