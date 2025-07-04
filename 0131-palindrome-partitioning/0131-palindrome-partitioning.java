class Solution {
    private void helper(List<List<String>> res, List<String> temp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) { 
            if (ispalin(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                helper(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean ispalin(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(res, temp, s, 0);
        return res;
    }
}