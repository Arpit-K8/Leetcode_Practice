class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) return new int[0][0];

        // Sort intervals by start time // we use this becuase of 2d array
        // other wise Arrays,sort is enough
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Add the first interval to the result
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                // Overlap: merge
                last[1] = Math.max(last[1], current[1]);
            } else {
                // No overlap: add to result
                result.add(current);
            }
        }

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}