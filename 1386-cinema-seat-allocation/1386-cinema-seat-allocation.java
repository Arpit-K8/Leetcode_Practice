class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<String>> blocked = new HashMap<>();
        for (int[] reservation : reservedSeats) {
            int row = reservation[0];
            int col = reservation[1];
            if (col == 1 || col == 10) continue;
            Set<String> set = blocked.computeIfAbsent(row, k -> new HashSet<>());

            if (col >= 2 && col <= 5) set.add("left");
            if (col >= 4 && col <= 7) set.add("middle");
            if (col >= 6 && col <= 9) set.add("right");
        }
        int total = 2 * (n - blocked.size());
        int[] numAvailable = {2,1, 1, 0};
        for (Set<String> blocks : blocked.values()) {
            total += numAvailable[blocks.size()];
        }
        return total;
    }
}