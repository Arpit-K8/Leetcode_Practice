class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleSum=0;
        for(int val:apple)appleSum+=val;
        Arrays.sort(capacity);
        int count=0,index=capacity.length-1;
        while(appleSum>0){
            appleSum-=capacity[index--];
            count++;
        }
        return count;
    }
}