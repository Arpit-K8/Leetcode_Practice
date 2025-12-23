class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)-> a[0]-b[0]);
        int end[][] = events.clone();
        Arrays.sort(end, (a,b)-> a[1]-b[1]);
        int l= events.length;

        int maxV[] = new int[l];
        maxV[0] = end[0][2];
        for(int i=1; i<l; i++){
            maxV[i] = Math.max(maxV[i-1], end[i][2]);
        }
        int ans =0, j=0;
        for(int i=0; i<l; i++){
            int st= events[i][0];
            int vl = events[i][2];
            while(j<l && end[j][1] < st){
                j++;
            }
            ans = Math.max(ans, vl);
            if(j>0){
                ans = Math.max(ans, vl + maxV[j-1]);
            }
        }
        return ans;
    }
}