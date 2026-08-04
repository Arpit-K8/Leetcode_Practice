class Solution {
    int[] parent = new int[26];
    int[] rank = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++) parent[i] = i;
        for(String eq :equations){ // for this equation ==
            if(eq.charAt(1) == '='){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';

                union(x,y);
            }
        }
        // Now for this !=
        for(String eq :equations){ // for this equation ==
            if(eq.charAt(1) == '!'){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';

                if(find(x) == find(y)) return false;
            }
        }
        return true;
    }
    private int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) return;

        if (rank[parentX] > rank[parentY]) parent[parentY] = parentX;
        else if (rank[parentX] < rank[parentY]) parent[parentX] = parentY;
        else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }
}