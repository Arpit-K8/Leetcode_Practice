class Solution {
    public int longestValidParentheses(String s) {
        int count = 0 ;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i); // storing index of (
            else{
                if(!stack.isEmpty()) stack.pop(); // deleting the matching one
                
                if(stack.isEmpty()) stack.push(i); // new base
                else count = Math.max(count,i-stack.peek());
            }
        }
        return count;   
    }
}
