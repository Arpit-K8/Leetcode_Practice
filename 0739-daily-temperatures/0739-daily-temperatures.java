class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = n-1 ; i >=0 ;i--){
            // poppin all indices with a lower or equal temp than te current index            
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            //if the stack still has elements then the next warmer temp exists
            if(!st.isEmpty()) res[i] = st.peek() - i; 
            st.push(i);
        }
        return res;
    }
}
