class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> ls = new ArrayList<>(map.keySet());
        ls.sort((a,b) -> map.get(b)-map.get(a));
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = ls.get(i);
        }
        return res;
    }
}