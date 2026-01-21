class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int Max=0,count=0;
        for(int num : nums){
            if(num == 1){
                count++;
                Max = Math.max(Max,count);
            } 
            else count = 0;
        }
        return Max;
    }
}