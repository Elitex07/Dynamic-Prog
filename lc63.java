class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(0, 0, m, n, obstacleGrid, memo);
    }
    private int helper(int x, int y, int m, int n, int[][] obstacleGrid, int[][] memo) {
        // If reached destination, there's exactly one path (stay)
        if (x >= m || y >= n || obstacleGrid[x][y] == 1) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        if (memo[x][y] != -1) return memo[x][y];

        int ways = 0;
        // Move down
        if (x + 1 < m) {
            ways += helper(x + 1, y, m, n, obstacleGrid, memo);
        }
        // Move right
        if (y + 1 < n) {
            ways += helper(x, y + 1, m, n, obstacleGrid, memo);
        }

        memo[x][y] = ways;
        return ways;
    }
}