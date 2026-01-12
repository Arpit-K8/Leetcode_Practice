class Solution {
    private int First(int[] arr, int target){
        int ans = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }
    private int Last(int[] arr, int target){
        int ans = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = First(nums, target);
        int last = Last(nums, target);
        return new int[]{first, last};
    }
}