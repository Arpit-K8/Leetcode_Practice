class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> ls = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] c, int target) {
        solver(c, target, 0);
        return ans;
    }
    public void solver(int[] c, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls)); 
            return;
        }
        for (int i = start; i < c.length; i++) {
            if (c[i] <= target) {
                ls.add(c[i]);
                solver(c, target - c[i], i); 
                ls.remove(ls.size() - 1); 
            }
        }
    }
}