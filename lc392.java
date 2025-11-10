import java.util.*;

class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<String, Boolean> memo = new HashMap<>();
        return isSubsequenceHelper(s, t, 0, 0, memo);
    }
    
    private boolean isSubsequenceHelper(String s, String t, int i, int j, Map<String, Boolean> memo) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // Base cases
        if (i == s.length()) {
            return true;  // We've matched all characters in s
        }
        if (j == t.length()) {
            return false;  // We've exhausted t but haven't matched all of s
        }
        
        // If current characters match, we can include this character
        boolean result;
        if (s.charAt(i) == t.charAt(j)) {
            result = isSubsequenceHelper(s, t, i + 1, j + 1, memo);
        } else {
            // If they don't match, try next character in t
            result = isSubsequenceHelper(s, t, i, j + 1, memo);
        }
        
        memo.put(key, result);
        return result;
    }
}