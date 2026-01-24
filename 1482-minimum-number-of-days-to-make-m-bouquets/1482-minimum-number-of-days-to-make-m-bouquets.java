class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int left = bloomDay[0];
        int right = bloomDay[0];
        for (int num : bloomDay) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMake(mid, bloomDay, k) >= m) right = mid - 1; // try smaller days
            else left = mid + 1;  // need more days
        }
        return left;
    }

    private int canMake(int mid, int[] bloomDay, int k) {
        int bouquetCount = 0;
        int consecutiveCount = 0;
        for (int day : bloomDay) {
            if (day <= mid) {
                consecutiveCount++;
                if (consecutiveCount == k) {
                    bouquetCount++;
                    consecutiveCount = 0;
                }
            }
            else consecutiveCount = 0;
        }
        return bouquetCount;
    }
}