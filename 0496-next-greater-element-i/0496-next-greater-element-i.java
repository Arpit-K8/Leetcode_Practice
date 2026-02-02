class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nextGreaterElements = new int[n];
        Stack<Integer> helperStack = new Stack<>();
        // Step 1: Compute NGE for nums2
        for (int i = n - 1; i >= 0; i--) {
            int element = nums2[i];
            while (!helperStack.isEmpty() && helperStack.peek() <= element) {
                helperStack.pop();
            }
            if (helperStack.isEmpty()) nextGreaterElements[i] = -1;
            else nextGreaterElements[i] = helperStack.peek();
            helperStack.push(element);
        }
        // Step 2: Store value -> NGE mapping
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], nextGreaterElements[i]);
        }
        // Step 3: Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
