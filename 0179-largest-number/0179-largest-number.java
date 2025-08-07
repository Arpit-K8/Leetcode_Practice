class Solution {
    public String largestNumber(int[] nums) {
        // Convert int[] to String[]
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        // Sort using custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        // Edge case: if the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        // Build the final result
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }
        return result.toString();
    }
}