class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1]; 
        for (int[] op : bookings) {
            int l = op[0]; 
            int r = op[1];
            int v = op[2]; 

            diff[l - 1] += v; 
            if (r < n) diff[r] -= v; 
        }

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            arr[i] = sum;
        }
        return arr;
    }
}
