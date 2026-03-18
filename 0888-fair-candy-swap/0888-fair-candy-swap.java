class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
            for (int candy : aliceSizes) {
            sumA += candy;
        }
        for (int candy : bobSizes) {
            sumB += candy;
        }
        int diff = sumA - sumB;
        int target = diff / 2;
        Set<Integer> bobSet = new HashSet<>();
        for (int candy : bobSizes){
            bobSet.add(candy);
        }
        for (int x : aliceSizes){
            int y = x - target; 
            if (bobSet.contains(y)) return new int[] { x, y };
        }
        return new int[] { -1, -1 };  
    }
}