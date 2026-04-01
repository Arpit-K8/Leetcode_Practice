class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] ind = new Integer[n];
        for (int i = 0; i < n; i++) ind[i] = i;
        Stack<Integer> st = new Stack<>();
        Arrays.sort(ind, (i, j) -> Integer.compare(positions[i], positions[j]));
        List<Integer> res = new ArrayList<>();
        for (int currInd : ind) {
            if (directions.charAt(currInd) == 'R') st.push(currInd);
            else {
                while (!st.isEmpty() && healths[currInd] > 0) {
                    int topInd = st.pop();
                    if (healths[topInd] > healths[currInd]) {
                        healths[topInd] -= 1;
                        healths[currInd] = 0;
                        st.push(topInd);
                    } else if (healths[topInd] < healths[currInd]) {
                        healths[currInd] -= 1;
                        healths[topInd] = 0;
                    } else {
                        healths[currInd] = 0;
                        healths[topInd] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }
        return res;
    }
}