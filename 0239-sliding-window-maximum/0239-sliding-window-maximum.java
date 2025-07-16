class Solution {
    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //Maintaining the window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            //If curr element is greater than all the existing elements in the deque,
            //then remove all the existing elements from deque and then add the curr element. Because we want to keep the max element only.
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            //Start adding into the result after i value passes the kth iteration.
            //Ex: k = 3, so after i reaches the (k-1) = 2nd index, start adding into the result
            if (i >= k - 1) {
                res[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return res;
    }
}