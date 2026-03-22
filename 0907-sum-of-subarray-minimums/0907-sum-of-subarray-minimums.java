class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n =arr.length;
        int mod = 1000000007;
        long sum = 0;
        int [] nse = solver1(arr); // Next Smaller Element arr
        int [] pse = solver2(arr); // prev Smaller Element arr

        for(int i = 0 ; i <n;i++){
            long ans = (long)arr[i]*nse[i]*pse[i];
            sum = (sum + ans)% mod;
        }
        return (int)sum;
    }
    private int[] solver1(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i >=0 ;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) nse[i] = n-i;
            else nse[i] = st.peek()-i;
            st.push(i); 
        }
        return nse;
    }
    private int[] solver2(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()) pse[i] = i+1; // count of element exit(include itself)
            else pse[i] = i- st.peek();
            st.push(i); 
        }
        return pse;
    }
}