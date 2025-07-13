class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;

        // Step 1: Sort the intervals based on start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Merge overlapping intervals
        List<int[]> merged = new ArrayList<>();
        int[] current = meetings[0];
        merged.add(current);

        for (int[] interval : meetings) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping, merge
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add next interval
                current = interval;
                merged.add(current);
            }
        }

        // Step 3: Count total meeting days from merged intervals
        int meetingDays = 0;
        for (int[] interval : merged) {
            meetingDays += interval[1] - interval[0] + 1;
        }

        // Step 4: Return non-meeting days
        return days - meetingDays;
    }
}
