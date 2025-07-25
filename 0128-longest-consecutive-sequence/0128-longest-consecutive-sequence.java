class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // for Duplicacy
        for (int n : nums) set.add(n);
        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) { // creating starting point
                int curr = n;
                // pre increment the ele then check it for existence, if yes then keep going
                while (set.contains(++curr));  
                max = Math.max(max, curr - n);
            }
        }
        return max;
    }
}