class Solution {
    public int hIndex(int[] citations) {
        // code here
        int size = citations.length;
        int[] arr = new int[size+1];
        
        for(int num : citations){
            if (num > size) arr[size]++;
            else arr[num]++;
        }
        int count = 0;
        for(int i = size;i>=0;i--){
            count+= arr[i];
            if(count>=i) return i;
        }
        return 0;
    }
}