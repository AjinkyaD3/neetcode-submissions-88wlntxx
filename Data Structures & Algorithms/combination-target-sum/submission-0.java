class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList(), nums , target , 0);
        return res;   
    }
    void backtrack(List<List<Integer>> res ,List<Integer> temp, int[] nums , int target , int start ){
        if(target == 0 ){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) return ;
        
        for(int i = start ; i < nums.length ; i++){

            if(nums[i] > target )break;

            temp.add(nums[i]);
            backtrack(res,temp, nums , target- nums[i] , i);
            temp.remove(temp.size()-1);
        }
    }

}
