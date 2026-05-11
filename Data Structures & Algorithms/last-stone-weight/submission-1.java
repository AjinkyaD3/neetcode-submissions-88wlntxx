class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s : stones){
            q.offer(s);
        }
        while(q.size()>1){
            int res = Math.abs(q.poll() - q.poll());
            if(res != 0){
                q.offer(res);
            }
        }
        return q.peek() == null ? 0 : q.peek();
        
    }
}


