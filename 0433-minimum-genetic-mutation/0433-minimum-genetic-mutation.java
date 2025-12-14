class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankset = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        visited.add(startGene);
        int lvl = 0;
        while(!q.isEmpty()){
           int n = q.size();
           while (n-- > 0) {
                String curr = q.poll();
                if (curr.equals(endGene)) return lvl;
                for (char ch : "ACGT".toCharArray()) {
                    for (int i = 0; i < curr.length(); i++) {
                        char[] neighbourArr = curr.toCharArray();
                        neighbourArr[i] = ch;
                        String neighbour = new String(neighbourArr);
                        
                        if (!visited.contains(neighbour) && bankset.contains(neighbour)) {
                            visited.add(neighbour);
                            q.offer(neighbour);
                        }
                    }
                }
            }
            lvl++;
        }
        return -1;
    }
}

