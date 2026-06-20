class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int []arr=new int[n];
        int l=0,r=n-1;
        int j=n-1;
        while(l<=r)
        {
            int rsq=nums[r]*nums[r];
            int lsq=nums[l]*nums[l];
            if(rsq>lsq)
            {
                arr[j--]=rsq;
                r--;
            }
            else
            {
                arr[j--]=lsq;
                l++;
            }
        }
        return arr;
    }

}