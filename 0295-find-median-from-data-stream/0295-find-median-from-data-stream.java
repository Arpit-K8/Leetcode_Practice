public class MedianFinder {
    private PriorityQueue<Integer> left; // LeftMaxHeap
    private PriorityQueue<Integer> right; // rightMinHeap
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek()) left.add(num);
        else right.add(num);
        
        // always maintain leftMaxHeap size one greater than right size or both sizes equal
        if (Math.abs(left.size() - right.size()) > 1) right.add(left.poll());
        else if (left.size() < right.size()) left.add(right.poll());
    }
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2; // for even
        }
        return left.peek(); // for odd
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */