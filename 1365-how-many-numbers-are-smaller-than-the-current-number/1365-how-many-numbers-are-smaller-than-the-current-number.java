class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        
        // store first occurrence index
        for(int i = 0; i < sorted.length; i++){
            map.putIfAbsent(sorted[i], i);
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
