import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(s, dict, 0, dp);
    }

    private boolean helper(String s, Set<String> dict, int start, Boolean[] dp) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (dict.contains(sub) && helper(s, dict, end, dp))
                return dp[start] = true;
        }

        return dp[start] = false;
    }
}