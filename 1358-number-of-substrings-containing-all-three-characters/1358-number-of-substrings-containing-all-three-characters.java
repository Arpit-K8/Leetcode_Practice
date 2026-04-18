class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int[] arr = new int[3]; // 0 - a, 1 - b, 2 - c
        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            arr[ch - 'a']++;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                res += (n - j);
                arr[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return res;
    }
}