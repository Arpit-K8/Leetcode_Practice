class Solution {
    Map<Integer, String> mp = new HashMap<>();
    ArrayList<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if( n == 0 ) return new ArrayList<String>();
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
        StringBuilder sb = new StringBuilder();
        solve(0, digits, sb);
        return result;
    }
    private void solve(int idx, String digits, StringBuilder sb) {
        if( idx >= digits.length() ) {
            result.add(sb.toString());
            return;
        }        
        char ch = digits.charAt(idx);
        String str = mp.get(ch - '0');
        for( int i = 0; i < str.length(); i++ ) {
            sb.append(str.charAt(i));
            solve(idx + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);  
        }
    }
}