class Solution {
public:
    int reverse(int x) {
        int ld,flag = 0;
        long long int rev= 0;
        while(x){
            ld = x%10; // last digit
            rev = rev*10 + ld;
            x/=10;
        }
        if(rev>INT_MAX || rev<INT_MIN) return 0; // check range also (constraint)  
        return int(rev);
    }
};