class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>() ,nums , 0); 
        return res;
        
    }
    void backtrack(List<List<Integer>> resultList,List<Integer> temp ,int[] nums , int start){

        resultList.add(new ArrayList<>(temp));  

        for(int i = start; i<nums.length;i++){ 
            if(i>start && nums[i] == nums[i-1]){
                continue;
            } 
            temp.add(nums[i]);        
            backtrack(resultList,temp ,nums , i+1);
            temp.remove(temp.size() -1);
        }
    
}
}



