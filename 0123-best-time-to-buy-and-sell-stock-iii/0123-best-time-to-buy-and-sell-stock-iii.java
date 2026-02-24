class Solution {
    public int maxProfit(int[] p) {
        int profit1=0;
        int profit2=0;
        int mn1=Integer.MAX_VALUE;
        int mn2=Integer.MAX_VALUE;
        for(int i=0;i<p.length;i++){
            mn1=Math.min(p[i],mn1);
            profit1=Math.max(profit1,p[i]-mn1);
            mn2=Math.min(mn2,p[i]-profit1);
            profit2=Math.max(profit2,p[i]-mn2);
        }
        return profit2;
    }
}