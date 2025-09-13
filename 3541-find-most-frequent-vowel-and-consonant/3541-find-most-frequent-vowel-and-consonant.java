class Solution {
    public int maxFreqSum(String s) {
        int vow = 0, cons = 0;
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                vow = Math.max(vow, freq[i - 'a']);
            } else {
                cons = Math.max(cons, freq[i - 'a']);
            }
        }

        return vow + cons;
    }
}