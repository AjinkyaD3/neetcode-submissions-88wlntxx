class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int max =0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                   int res =  dfs(grid,i,j);
                    max = Math.max(res,max);
                }
            }
        }
        return max;

        
    }
    int dfs(int[][] grid,int row , int col){

        if (row < 0 || row >= grid.length ||         col < 0 || col >= grid[0].length ||         grid[row][col] == 0)   {
        return 0;  }
    grid[row][col] = 0;

    int res = dfs(grid,row+1,col) + dfs(grid,row-1,col) +  dfs(grid,row,col+1) + dfs(grid,row,col-1);
    return res+1;

    }   
}
