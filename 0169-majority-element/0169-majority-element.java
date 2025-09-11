class Solution {
    public int majorityElement(int[] arr) {
    //     for(int i =0 ;i < arr.length;i++){
    //         int count = 0;
    //         for (int j = 0 ; j<arr.length;j++){
    //             if(arr[i] == arr[j]) count++;
    //         }
    //         int n = arr.length;
    //         if(count > n/2) return arr[i];
    //     }
    // return -1;
    int lead = 0, cand = 0;
    for(int i = 0; i < arr.length; i++) {
        if(lead == 0) {
            cand = arr[i];
            lead = 1;
        } else if(arr[i] == cand) {
            lead++;
        } else {
            lead--;
        }
    }
    return cand;
    }
}