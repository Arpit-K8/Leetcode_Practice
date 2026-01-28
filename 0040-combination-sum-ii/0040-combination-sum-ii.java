class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> ans) {
        // Base case: target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // If candidate exceeds target, break (since sorted)
            if (candidates[i] > target) break;

            // Choose candidates[i]
            current.add(candidates[i]);
            // Move to next index (i+1) since each number can be used once
            backtrack(candidates, target - candidates[i], i + 1, current, ans);
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}