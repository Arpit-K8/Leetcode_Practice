public class Solution { // [ [] ]
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();  

        for (String str : strs) { // str = tea
            char[] charc = str.toCharArray(); // charc = ['t','e','a'];
            Arrays.sort(charc); // charc = ['a','e','t'];
            String sortedStr = new String(charc); // sortedStr = "aet" 
            // If key doesn't exist, creating the new one
            if (!map.containsKey(sortedStr)) { // aet
                map.put(sortedStr, new ArrayList<>());// aet -> [eat,tea]
            } 
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}