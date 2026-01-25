public class Solution {
    public boolean possibleToPlace(int force, int[] position, int m) {
        int prev = position[0];
        int countBalls = 1;
        for (int i = 1; i < position.length; i++) {
            int curr = position[i];
            if (curr - prev >= force) {
                countBalls++;
                prev = curr;
            }
            if (countBalls == m) break;
        }
        return countBalls == m;
    }

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 1;
        int right = position[n - 1] - position[0]; // This value is the maximum possible distance

        while (left <= right) {
            int midForce = left + (right - left) / 2;
            if (possibleToPlace(midForce, position, m)) left = midForce + 1;
            else right = midForce - 1;
        }
        return right;// now right should be correct one to return 
    }
}