class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {  
            int temp = b;  // Remember the current value
            b = a % b;    // Find the remainder 
            a = temp;     // Swap values for next round
        }
        return a;  
    }
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0; 
        return (a / gcd(a, b)) * b;  
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            int current = num; 
            while (!stack.isEmpty() && gcd(stack.peek(), current) > 1) {
                int top = stack.pop();
                current = lcm(top, current);
            }
            stack.push(current);
        }
        return new ArrayList<>(stack);
    }
}