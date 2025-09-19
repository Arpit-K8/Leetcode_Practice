class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0; // Counter for valid vowel substrings
        int n = word.length(); // Length of the input string
        // Set of vowels for quick lookup
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        // Outer loop: try every starting index of the substring
        for (int i = 0; i < n; i++) {
            // Skip if starting character is not a vowel
            if (!vowels.contains(word.charAt(i))) continue;
            Set<Character> seen = new HashSet<>(); // Track vowels seen in current substring
            // Inner loop: expand the substring from index i
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                // Stop if a non-vowel is encountered
                if (!vowels.contains(ch)) break;
                // Add vowel to the set
                seen.add(ch);
                if (seen.size() == 5) count++;
            }
        }
        return count;
    }
}