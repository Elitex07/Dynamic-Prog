class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return helper(0, s, memo);
    }
    private int helper(int index, String s, int[] memo) {
        // If reached the end of the string, there's exactly one way to decode (do nothing)
        if (index == s.length()) return 1;
        if (memo[index] != -1) return memo[index];

        if (s.charAt(index) == '0') return 0;

        int ways = 0;
        ways += helper(index + 1, s, memo);

        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += helper(index + 2, s, memo);
            }
        }

        memo[index] = ways;
        return ways;
    }
}