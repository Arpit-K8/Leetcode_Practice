class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : result) {
                if (2 * num - 1 <= n) temp.add(2 * num - 1); // odd
            }
            for (int num : result) {
                if (2 * num <= n) temp.add(2 * num); // even
            }
            result = temp;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = result.get(i);
        return ans;
    }
}