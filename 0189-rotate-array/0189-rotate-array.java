class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %=n;

        Reverse(nums,0,n-1); 
        Reverse(nums,0,k-1); 
        Reverse(nums,k,n-1); 
    }
    private void Reverse(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;end--;
        }
    }
}