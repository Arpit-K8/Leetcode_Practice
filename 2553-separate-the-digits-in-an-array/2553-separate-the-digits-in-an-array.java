class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();        
        for (int num : nums) {
            sb.append(num);
        }  
        List<Integer> ls = new ArrayList<>();
        for (char ch : sb.toString().toCharArray()) {
            ls.add(ch - '0');
        } 
        int[] result = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            result[i] = ls.get(i);
        }
        return result;
    }
}