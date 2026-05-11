 class Solution {

    public int[][] kClosest(int[][] points, int k) {

       
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(b), distance(a))
        );

        for (int[] point : points) {

            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private double distance(int[] point) {

        int x = point[0];
        int y = point[1];

        return Math.sqrt((x * x) + (y * y));
    }
}