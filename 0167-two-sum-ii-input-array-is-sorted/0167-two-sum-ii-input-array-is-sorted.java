class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int left = 0,right = numbers.length - 1;
        // while (left < right) {
        //     int sum = numbers[left] + numbers[right];
        //     if (sum == target) {
        //         return new int[] {left + 1, right + 1};
        //     } else if (sum < target) {
        //         left++; 
        //     } else {
        //         right--;
        //     }
        // }
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<numbers.length;i++){
            int comp = target - numbers[i];
            if(mp.containsKey(comp)){
                return new int[] {mp.get(comp)+1,i+1};
            }
            mp.put(numbers[i],i);
        }
        return new int[] {-1, -1};
    }
}