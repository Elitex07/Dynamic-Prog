import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, dp, 0);
    }
    private int helper(int[] nums, int[] dp, int ind) {
        int n = nums.length;
        if (ind >= n) return 0;
        if (dp[ind] != -1) return dp[ind];

        int take = nums[ind] + helper(nums, dp, ind + 2);
        int notTake = helper(nums, dp, ind + 1);

        dp[ind] = Math.max(take, notTake);
        return dp[ind];
    }
}