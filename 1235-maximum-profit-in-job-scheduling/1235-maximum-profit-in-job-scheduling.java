class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0); // base case: time 0, profit 0

        for (Job job : jobs) {
            Integer prevTime = dp.floorKey(job.start);
            int currProfit = dp.get(prevTime) + job.profit;

            if (currProfit > dp.lastEntry().getValue()) {
                dp.put(job.end, currProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

    class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
}