class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            int curr = reverse(nums[i]);
            if(mp.containsKey(curr)){
                ans = Math.min(ans,Math.abs(i- mp.get(curr)));
            }
            mp.put(nums[i],i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int reverse(int num){
        int res = 0;
        while(num!=0){
            res = res*10+num%10;
            num/=10;
        }
        return res;
    }
}