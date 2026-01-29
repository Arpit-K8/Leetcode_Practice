class Solution {
    public int searchInsert(int[] arr, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] >= target) {
        //         return i;
        //     }
        // }
        // return nums.length;
        int left = 0, right = arr.length; // [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left; // first index where arr[i] >= target
    }
}





// class Solution {
//     int lowerBound(int[] arr, int target) {
//         int left = 0, right = arr.length; // [left, right)

//         while (left < right) {
//             int mid = left + (right - left) / 2;

//             if (arr[mid] < target)
//                 left = mid + 1;
//             else
//                 right = mid;
//         }
//         return left; // first index where arr[i] >= target
//     }

//     public int searchInsert(int[] nums, int target) {
//         return lowerBound(nums, target);
//     }
// }
