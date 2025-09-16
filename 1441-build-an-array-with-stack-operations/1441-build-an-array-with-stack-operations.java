class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int k=0;
        int curr = target[k];
        for(int i=1;i<=n;i++){
            
            if(curr != i){
                list.add("Push");
                list.add("Pop");
            }else{
                list.add("Push");
                k++;
                if(k>=target.length) break;
                curr = target[k];
            }
        }
        return list;
    }
}