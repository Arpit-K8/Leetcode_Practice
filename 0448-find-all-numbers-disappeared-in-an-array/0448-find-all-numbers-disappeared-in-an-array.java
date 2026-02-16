class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[n+1];
        for(int num :nums){
            freq[num]++;
        }
        for(int i= 1;i<=n;i++){
            if(freq[i] == 0) res.add(i);
        }
        return res;
    }
}