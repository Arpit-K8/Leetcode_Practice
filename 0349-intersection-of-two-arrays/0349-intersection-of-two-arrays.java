class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        // Put all of nums1 into a VIP list (Set automatically handles duplicates)
        for (int i = 0; i < nums1.length; i++) {
            st.add(nums1[i]);
        }
        // Check who from nums2 is on the VIP list
        for (int i = 0; i < nums2.length; i++) {
            if (st.contains(nums2[i])) {
                arr.add(nums2[i]);
                // VIP passed through, remove from list to prevent multiple entries
                st.remove(nums2[i]); 
            }
        }
        // Convert the dynamic list back to dumb array format for LeetCode answer format
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}