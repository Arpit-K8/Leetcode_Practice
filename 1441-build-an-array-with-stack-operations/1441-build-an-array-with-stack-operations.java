class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;  // pointer for target
        for(int i = 1; i <= n; i++){
            if(index == target.length) break;
            res.add("Push");
            
            if(i == target[index]) index++;  // move to next target element
            else res.add("Pop");
        }
        
        return res;
    }
}
