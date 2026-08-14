class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int number : nums) {
            totalSum += number;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;

        boolean[] canMakeSum = new boolean[targetSum + 1];
        canMakeSum[0] = true;

        for (int number : nums) {
            for (int currentSum = targetSum; currentSum >= number; currentSum--) {
                if (canMakeSum[currentSum - number]) {
                    canMakeSum[currentSum] = true;
                }
            }
        }

        return canMakeSum[targetSum];
    }
}