class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = piles[0];
        int ans=0;
        for (int pile : piles) {
            // if (pile > max) max = pile;
            max = Math.max(pile,max);
        }
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid, piles, h)){
                ans = mid;
                right = mid - 1; 
            } 
            else left = mid + 1;
        }
        return ans;
    }
    private boolean isPossible(int mid, int[] piles, int h) {
        long sum = 0;
        for (int num : piles) {
            sum += num / mid;
            if (num % mid != 0) sum++;
        }
        return sum <= h; // then Koko can eat all otherwise it will be caught
    }
}
