class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int k, int target, int start,
                           List<Integer> current, List<List<Integer>> res) {
        if (current.size() == k && target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (current.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {
            current.add(i); // do
            backtrack(k, target - i, i + 1, current, res); // explore
            current.remove(current.size() - 1); // undo
        }
    }
}