class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid, piles, h)) right = mid - 1; 
            else left = mid + 1;
        }
        return left;
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
