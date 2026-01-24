class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w); // minimum capacity
            right += w;               // maximum capacity
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, weights, days)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    private boolean isPossible(int capacity, int[] weights, int days) {
        int usedDays = 1;
        int currLoad = 0;
        for (int w : weights) {
            if (currLoad + w <= capacity) {
                currLoad += w;
            } else {
                usedDays++;
                currLoad = w;
            }
        }
        return usedDays <= days;
    }
}
