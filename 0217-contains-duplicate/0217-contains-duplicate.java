class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int temp = -1;
        boolean ans= false;
        for(int num : nums){
            if(num == temp) ans = true;
            temp = num;
        }
        return ans;
    }
}