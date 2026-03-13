class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n > 12) return res; // IP address can't exceed 12 digits
        solve(s, 0, 0, "", res, n);
        return res;
    }
    private void solve (String s, int idx, int part, String curr, List<String> res, int n){
        if (idx == n && part == 4) {
            res.add(curr.substring(0, curr.length() - 1)); // remove trailing dot
            return;
        }
        if (part >= 4) return; // can't have more than 4 parts
        // Try 1 digit
        if (idx + 1 <= n) {
            solve(s, idx + 1, part + 1, curr + s.substring(idx, idx + 1) + ".", res, n);
        }
        // Try 2 digits
        if (idx + 2 <= n && isValid(s.substring(idx, idx + 2))) {
            solve(s, idx + 2, part + 1, curr + s.substring(idx, idx + 2) + ".", res, n);
        }
        // Try 3 digits
        if (idx + 3 <= n && isValid(s.substring(idx, idx + 3))) {
            solve(s, idx + 3, part + 1, curr + s.substring(idx, idx + 3) + ".", res, n);
        }
    }
    private boolean isValid(String str) {
        if (str.charAt(0) == '0' && str.length() > 1) return false; // leading zero not allowed
        int val = Integer.parseInt(str);
        return val <= 255;
    }
}