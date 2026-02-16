class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if(isOperator(token)){
                int first = st.pop();
                int second = st.pop();
                int res = solve(first,second,token);
                st.push(res);
            }
            else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private int solve(int a, int b, String token){
        if(token.equals("+")) return a+b;
        else if(token.equals("-")) return b-a;
        else if(token.equals("*")) return a*b;
        else return b/a;
    }
}