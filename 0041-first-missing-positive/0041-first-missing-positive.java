class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;

        // Place every number at its correct index
        while (i < n) {

            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= n &&
                nums[i] != nums[correctIndex]) {

                // Swap elements
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else {
                i++;
            }
        }

        // Find the first missing positive number
        for (int j = 0; j < n; j++) {

            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        // If all numbers are present
        return n + 1;
    }
}