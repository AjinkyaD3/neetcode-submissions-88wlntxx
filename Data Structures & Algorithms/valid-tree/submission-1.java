class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int neighbour : list.get(node)) {
                if (visited.contains(neighbour))
                    continue;

                visited.add(neighbour);
                stack.push(neighbour);
            }
        }

        return visited.size() == n;
    }
}