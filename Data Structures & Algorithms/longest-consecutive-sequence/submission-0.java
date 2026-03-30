class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

         int count = 1;
         for(int n : set){
            if(set.contains(n-1)){
                continue;
            }else{
                int currentno = n;
                int currentsub = 1;
                while(set.contains(currentno+1)){
                    currentno++;
                    currentsub++;
                }

                count = Math.max(count,currentsub);

            }
         }

         return count;

    }
}