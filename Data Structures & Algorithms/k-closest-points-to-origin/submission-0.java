class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max Heap based on distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            pq.offer(point);

            // Keep only k elements in heap
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

    // Squared Euclidean Distance
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}