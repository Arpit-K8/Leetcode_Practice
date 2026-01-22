class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] arr = new int[size];
        int idx = 0;
        for (int[] row : grid) { // 2d to 1d
            for (int num : row) {
                arr[idx++] = num;
            }
        }
        int[] frequency = new int[size + 1];
        int repeating = -1, missing = -1;
        
        for (int num : arr) frequency[num]++;

        for (int i = 1; i <= size; i++) {// ac to ques valid 1 to n that's why start from 1
            if (frequency[i] == 2) repeating = i;
            else if (frequency[i] == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }
}