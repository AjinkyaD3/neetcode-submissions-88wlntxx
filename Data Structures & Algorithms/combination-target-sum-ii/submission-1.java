class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, target, 0);
        return res;
    }

    void backtrack(List<List<Integer>> res,
                   List<Integer> temp,
                   int[] nums,
                   int target,
                   int start) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            temp.add(nums[i]);

            // Move to next index since each element can be used once
            backtrack(res, temp, nums, target - nums[i], i + 1);

            temp.remove(temp.size() - 1);
        }
    }
}