class Solution {
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] charArray = s.toCharArray();
        // Step 1: Extract all vowels
        for (char c : charArray) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        // Step 2: Sort the collected vowels
        Collections.sort(vowels);
        // Step 3: Replace vowels in the original string with sorted vowels
        int vowelIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (isVowel(charArray[i])) {
                charArray[i] = vowels.get(vowelIndex++);
            }
        }
        return new String(charArray);
    }
}