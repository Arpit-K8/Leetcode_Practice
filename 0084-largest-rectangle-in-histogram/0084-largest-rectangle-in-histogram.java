class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // right side
        for(int i = n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            // right[i] = s.isEmpty() ? -1 : s.peek();
            // but in case for right side if no value exist then i have to give 'n'
            // rather than -1 on the other hand in left it is correct because if no left side is there it means -1 is last so we will assign n instead of -1
            
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        // empty the stack for reuse becasue some of the element are there in it
        while(!s.isEmpty()) s.pop();

        // left side
        for(int i = 0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        //again empty the stack for resuse
        while(!s.isEmpty()) s.pop();

        int res=0;
        for(int i = 0;i<n;i++){
            int width = right[i]-left[i]-1;
            int Maxarea = heights[i]*width; // (length*breadth)
            res = Math.max(res,Maxarea);
        }
        return res;
    }
}