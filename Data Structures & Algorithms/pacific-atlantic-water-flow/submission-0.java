class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Pacific: left and top borders
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacificReachable, heights);
            dfs(i, cols - 1, atlanticReachable, heights);
        }

        // Atlantic: right and bottom borders
        for (int j = 0; j < cols; j++) {
            dfs(0, j, pacificReachable, heights);
            dfs(rows - 1, j, atlanticReachable, heights);
        }

        // Cells reachable from both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] reachable, int[][] heights) {
        reachable[row][col] = true;

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Out of bounds
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Already visited
            if (reachable[newRow][newCol]) {
                continue;
            }

            // Can only move to equal or higher heights (reverse DFS)
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, reachable, heights);
        }
    }
}