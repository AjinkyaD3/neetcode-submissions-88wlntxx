class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k )return nums;

        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = (int)map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

       

        int[] result = new int[k];
        int index =0;
        for(int i =bucket.length-1;i>=0 && index<k ; i--){
            if(bucket[i] != null){
                for(int n : bucket[i]){
                    result[index]=n;
                    index++;
                    if(index == k) break;
                }
            }

        }

        return result;

        
    }

   
}
