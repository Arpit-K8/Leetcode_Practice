class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr==null || arr.length<3) return new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();   // solution set must not contain 
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0){
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                }
                else if(sum<0) left++;
                else right--;
            }
        }
        return new ArrayList<>(result);
    }
}