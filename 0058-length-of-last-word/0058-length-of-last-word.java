class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // Remove leading/trailing spaces
        String[] words = s.split(" "); // Split by space
        return words[words.length - 1].length(); // Length of last word
    }
}