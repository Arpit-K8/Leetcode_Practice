class Solution {
    private void solver(int[] nums, List<List<Integer>> res,List<Integer> temp,int start){
        if(temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for(int i = 0 ; i < nums.length;i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            solver(nums,res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solver(nums,res,temp,0);
        return res;
    }
}