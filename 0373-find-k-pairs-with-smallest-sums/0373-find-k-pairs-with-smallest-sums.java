class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if (m==0 || n==0 || k==0) return res;
        // Min-heap
        // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<String> visited = new HashSet<>();
        pq.offer(new int[]{nums1[0] + nums2[0],0,0}); // [sum, i, j]
        visited.add("0,0");

        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < n && !visited.contains(i + "," + (j + 1))) { // Push (i, j+1)
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }
            if (i + 1 < m && !visited.contains((i + 1) + "," + j)) { // Push (i+1, j)
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }
        }
        return res;
    }
}