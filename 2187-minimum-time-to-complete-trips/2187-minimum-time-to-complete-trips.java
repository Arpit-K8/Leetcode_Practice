class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long min = time[0];
        for (int num : time) {
            if (num < min) min = num;
        }
        long right = min * totalTrips; // max possibility

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (ispossible(mid, time, totalTrips)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean ispossible(long mid, int[] time, int totalTrips) {
        long sum = 0;
        for (int num : time) {
            sum += mid / num;
        }
        return sum >= totalTrips;
    }
}
