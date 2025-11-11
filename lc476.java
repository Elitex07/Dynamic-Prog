import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(helper(cost, dp, cost.length - 1), helper(cost, dp, cost.length - 2));
    }
    private int helper(int[] costs, int[] dp, int ind) {
        if(ind == 0) return costs[0];
        if(ind == 1) return costs[1];

        if(dp[ind] != -1) return dp[ind];
        return dp[ind] = costs[ind] + Math.min(helper(costs, dp, ind - 1), helper(costs, dp, ind - 2));
    }
}