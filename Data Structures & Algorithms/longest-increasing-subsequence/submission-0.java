class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] T = new int[n];
        Arrays.fill(T, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    T[i] = Math.max(T[i], T[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, T[i]);
        }

        return max;
    }
}
