class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = weights[0];
        int sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int low = max, high = sum, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredDays = checkMid(weights, mid);
            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int checkMid(int[] weights, int capacity) {
        int sum = 0, days = 1;
        for (int weight : weights) {
            if (sum + weight <= capacity) {
                sum += weight;
            } else {
                sum = weight;
                days++;
            }
        }
        return days;
    }
}