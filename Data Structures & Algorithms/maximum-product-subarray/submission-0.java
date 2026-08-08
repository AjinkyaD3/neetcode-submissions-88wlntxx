class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            // if either product hit 0, reset to 1 (fresh start after a zero)
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];           // prefix product
            rightProduct *= nums[n - 1 - i];  // suffix product

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }
}