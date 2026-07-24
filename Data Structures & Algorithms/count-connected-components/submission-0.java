class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // Build graph
        for (int[] ar : edges) {
            list.get(ar[0]).add(ar[1]);
            list.get(ar[1]).add(ar[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, list, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> list, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, list, visited);
            }
        }
    }
}