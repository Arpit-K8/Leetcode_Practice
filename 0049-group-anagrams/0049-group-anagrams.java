public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>(); 
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);  
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);  
        }
        return new ArrayList<>(mp.values());  
    }
}
