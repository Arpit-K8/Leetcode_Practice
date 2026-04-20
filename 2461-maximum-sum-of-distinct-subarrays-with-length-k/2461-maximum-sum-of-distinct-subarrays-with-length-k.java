class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max=0,sum = 0;
        int i= 0; // left pointer
        Set<Integer> st = new HashSet<>();
        for(int j = 0;j<n;j++){
            while(st.contains(nums[j])){ // remove untill dup is wiped out
                st.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            st.add(nums[j]);
            sum+= nums[j];
            if(j-i+1== k){ // store then slide toward right
                max = Math.max(max,sum);
                st.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
        }
        return max;
    }
}