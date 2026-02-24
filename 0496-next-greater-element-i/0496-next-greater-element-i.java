class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <n; i++) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                map.put(st.pop(),nums2[i]);
            }
            st.push(nums2[i]);
        }
        for (int num : st){ // for rest element in stack
            map.put(num,-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]); // now find ele of arr1 in arr2 from there we will find NGE
        }
        return res;
    }
}
