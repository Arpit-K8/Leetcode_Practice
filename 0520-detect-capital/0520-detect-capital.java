class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCnt = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) upperCnt++;
        }
        return upperCnt == word.length() || upperCnt == 0 ||
            (upperCnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}