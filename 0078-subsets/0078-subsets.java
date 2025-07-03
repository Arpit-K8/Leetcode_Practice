class Solution {
    private void solver(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp)); // Make a copy to avoid mutation
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            solver(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solver(nums, res, temp, 0);
        return res;
    }
}