class MyStack {
    // Deque<Integer> q;
    Queue<Integer> q;
    public MyStack() {
        // q = new ArrayDeque<>();
        q = new LinkedList<>();
    }
    
    public void push(int x) {   
        q.offer(x); 
        // inorder to make stack via queue ill do rotation
        for(int i =0 ;i< q.size()-1;i++){ // we have inserted earlier (reason : we are getitng the null pointer error cause earlier i am try to pop without inserting any ele)
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        // return q.pollLast();
        return q.poll();
    }
    
    public int top() {
        // return q.peekLast();
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
// if i will use deq it become easy but ill implement via que only



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */