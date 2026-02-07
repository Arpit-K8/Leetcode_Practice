class Solution {
    public int minimumDeletions(String s) {
        int count = 0, del = 0;
        for(char ch : s.toCharArray()) {
            if(ch == 'b') count += 1;
            else if(count > 0 ) {
                count -= 1;
                del += 1;
            }
        }   
        return del;
    }
}