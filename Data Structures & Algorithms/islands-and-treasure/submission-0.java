class Solution {
    private static int INF = 2147483647;
    private static int[] DIRS = {0,1,0,-1,0};

    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;


        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < row ; i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }


        // bfs 

        while(!q.isEmpty()){
            int[] gate = q.poll();

            int r = gate[0];
            int c = gate[1];

            for(int i =0;i<4;i++){
                int newRow = r+DIRS[i];
                int newCol = c+DIRS[i+1];

                if(newRow >= 0 && newRow < row && newCol >=0 && newCol <col && grid[newRow][newCol] == INF  ){
                   grid[newRow][newCol] = grid[r][c]+1;

                   q.offer(new int[]{newRow,newCol});
                }
                
            }
        }

    }
}
