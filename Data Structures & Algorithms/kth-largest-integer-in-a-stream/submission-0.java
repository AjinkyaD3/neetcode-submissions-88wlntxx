class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        // Remove smallest if size exceeds k
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Top of heap = kth largest
        return minHeap.peek();
    }
}