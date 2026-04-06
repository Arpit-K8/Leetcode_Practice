class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int[] obs : obstacles) set.add(obs[0]+","+obs[1]);
                //  N, E,S ,W
        int[] dx = {0,1,0,-1}; 
        int[] dy = {1,0,-1,0};
        int x = 0,y=0;
        int dir = 0,max = 0;
        for(int num : commands){
            if(num==-1) dir = (dir+1)%4;
            else if(num == -2) dir = (dir+3)%4;
            else{
                for(int i =0 ;i<num;i++){
                    int nx = x+dx[dir];
                    int ny = y+dy[dir];
                    if(set.contains(nx+","+ny)) break;
                    x = nx;
                    y=ny;
                    max = Math.max(max, x*x+y*y);
                }
            }
        }
        return max;
    }
}