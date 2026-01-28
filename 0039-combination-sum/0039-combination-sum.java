class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] candidates, int target, int idx,
                           List<Integer> current, List<List<Integer>> ans) {
        // Base case: target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(current)); // add copy
            return;
        }

        // If target < 0 or index out of bounds, stop
        if (target < 0 || idx >= candidates.length) return;
        // Choice 1: include candidates[idx]
        current.add(candidates[idx]);
        backtrack(candidates, target - candidates[idx], idx, current, ans); // allow reuse
        current.remove(current.size() - 1); // backtrack

        // Choice 2: skip candidates[idx]
        backtrack(candidates, target, idx + 1, current, ans);
    }
}