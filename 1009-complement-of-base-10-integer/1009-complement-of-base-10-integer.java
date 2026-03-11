class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int mask = 0;
        int temp = n;
        while(temp > 0){
            mask = (mask << 1) | 1; // ye krne se ek jagah banega digit ka then or krdenge to bhar jayega then 000 -> 010 thne or krdenge 1 k sath so 011 bn jaygea
            temp >>= 1;
        }
        return mask ^ n;
    }
}