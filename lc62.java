class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(0, 0, m, n, memo);
    }

    private int helper(int x, int y, int m, int n, int[][] memo) {
        // If reached destination, there's exactly one path (stay)
        if (x == m - 1 && y == n - 1) return 1;
        if (memo[x][y] != -1) return memo[x][y];

        int ways = 0;
        // Move down
        if (x + 1 < m) {
            ways += helper(x + 1, y, m, n, memo);
        }
        // Move right
        if (y + 1 < n) {
            ways += helper(x, y + 1, m, n, memo);
        }

        memo[x][y] = ways;
        return ways;
    }
}