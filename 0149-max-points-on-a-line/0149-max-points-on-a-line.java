class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n; 
        int result = 2;
        for(int[] a : points){
            Map<Double, Integer> map = new HashMap<>();
            for(int[] b : points){
                if(a == b) continue; 
                double slope = 0;
                if(b[0] - a[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] -a[1]) / (double)(b[0] - a[0]);
                
                map.put(slope, map.getOrDefault(slope, 1)+1);
                result = Math.max(result, map.get(slope));             
            }
        } 
        return result;
    }
}