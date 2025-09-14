class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char lower = Character.toLowerCase(ch);
            sb.append(isVowel(lower) ? 'a' : lower);
        }
        return sb.toString();
    }

    private String convertToLower(String s) {
        return s.toLowerCase();
    }

    private String matched(List<String> list, String query) {
        // Exact match
        for (String word : list) {
            if (word.equals(query)) return word;
        }

        // Case-insensitive match
        String lowerQuery = convertToLower(query);
        for (String word : list) {
            if (convertToLower(word).equals(lowerQuery)) return word;
        }

        // Vowel-insensitive match
        String convertedQuery = convert(query);
        for (String word : list) {
            if (convert(word).equals(convertedQuery)) return word;
        }

        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordlist) {
            String key = convert(word);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        List<String> result = new ArrayList<>();
        for (String query : queries) {
            String key = convert(query);
            if (!map.containsKey(key)) {
                result.add("");
            } else {
                result.add(matched(map.get(key), query));
            }
        }

        // Convert List<String> to String[]
        return result.toArray(new String[0]);
    }
}