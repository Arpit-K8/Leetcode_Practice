class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 0: Add newInterval to intervals[]
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;

        // Step 1: Sort intervals by start time
        Arrays.sort(newIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Merge using same logic as in merge()
        List<int[]> merged = new ArrayList<>();
        int[] current = newIntervals[0];
        merged.add(current);

        for (int[] interval : newIntervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                current[1] = Math.max(currentEnd, nextEnd); // merge
            } else {
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
