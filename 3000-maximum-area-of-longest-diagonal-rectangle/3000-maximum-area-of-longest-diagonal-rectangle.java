class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = 0;
        int maxArea = 0;

        for (int[] dim : dimensions) {
            int len = dim[0], wid = dim[1];
            double diag = Math.sqrt((double)len * len + (double)wid * wid);

            if (diag > maxDiag || (diag == maxDiag && len * wid > maxArea)) {
                maxDiag = diag;
                maxArea = len * wid;
            }
        }

        return maxArea;
    }
}