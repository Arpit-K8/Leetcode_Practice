class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int num : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && num < 0 && st.peek() > 0) {
                if (st.peek() < -num) st.pop();
                else if (st.peek() == -num) {
                    st.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) st.push(num);
        }
        int[] res = new int[st.size()]; // converting
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}