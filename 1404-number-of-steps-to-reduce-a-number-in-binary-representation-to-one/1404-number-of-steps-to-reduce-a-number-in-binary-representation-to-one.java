class Solution {
    public int numSteps(String s) {
        // int num = Integer.parseInt(s,2);
        long num = Long.parseLong(s, 2);
        int step = 0;
        while(num>1){
            step++;
            if(num%2==0) num/=2;
            else num+=1;
        }
        return step;
    }
}