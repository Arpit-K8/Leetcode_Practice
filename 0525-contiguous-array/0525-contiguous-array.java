class Solution {
    public int findMaxLength(int[] nums) {
        // coverting all 0 to -1
        for(int i = 0 ; i < nums.length;i++)
            if(nums[i] == 0) nums[i] = -1;
        
        int sum = 0;
        int maxlen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // first i have to push it (start point)
        for(int i = 0 ; i < nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                int last = map.get(sum);
                maxlen = Math.max(maxlen,i-last);
            }
            else map.put(sum,i);
        }
        return maxlen;
    }
}