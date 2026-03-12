class Solution {
    public int maximumGap(int[] nums) {
        int len=nums.length;
        
        if(len<2)return 0;
        Arrays.sort(nums);
        int maxdiff=0;
        for(int j=0;j<len-1;j++){
          maxdiff=Math.max(maxdiff,Math.abs(nums[j]-nums[j+1]));
        }
        return maxdiff;
    }
}