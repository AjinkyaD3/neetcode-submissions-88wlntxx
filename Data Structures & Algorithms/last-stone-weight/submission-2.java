class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q =
            new PriorityQueue<>(Comparator.reverseOrder());

        for (int s : stones) {
            q.offer(s);
        }

        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();

            if (y != x) {
                q.offer(y - x);
            }
        }

        return q.isEmpty() ? 0 : q.poll();
    }
}