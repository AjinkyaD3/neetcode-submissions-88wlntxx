class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                int temp = matrix[i][j];

                // Bottom-left -> Top-left
                matrix[i][j] = matrix[n - 1 - j][i];

                // Bottom-right -> Bottom-left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // Top-right -> Bottom-right
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // Top-left -> Top-right
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
