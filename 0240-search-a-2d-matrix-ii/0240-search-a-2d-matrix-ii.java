class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int cols = matrix[0].length;
        int left = 0,right = row*cols-1;
        while(left <=right){
            int mid = left + (right-left)/2;

            int i = mid/cols;
            int j = mid % cols;
            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}