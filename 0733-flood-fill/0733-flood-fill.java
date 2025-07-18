class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length,c = image[0].length;
        int old = image[sr][sc];

        DFS(image,sr,sc,r,c,old,color); 
        return image;  
    }
    void DFS(int[][] image, int sr, int sc,int r,int c, int old,int color){
        if(sr == r || sc == c || sr < 0 || sc < 0 || image[sr][sc]!= old || image[sr][sc] == color) return;
        image[sr][sc] = color;
        DFS(image,sr,sc+1,r,c,old,color);
        DFS(image,sr-1,sc,r,c,old,color);
        DFS(image,sr,sc-1,r,c,old,color);
        DFS(image,sr+1,sc,r,c,old,color);
    }
}