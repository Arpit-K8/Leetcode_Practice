class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        // Initial penalty: if shop closes at 0, all 'Y' are penalties
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') penalty++;
        }
        int minPenalty = penalty;
        int bestHour = 0;
        for (int j = 0; j < n; j++) {
            if (customers.charAt(j) == 'Y') { // Moving past a 'Y' reduces penalty
                penalty--;
            } else { // Moving past an 'N' increases penalty
                penalty++;
            }
            // Update best hour if penalty is smaller
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j + 1; // because closing at hour j+1
            }
        }
        return bestHour;
    }
}