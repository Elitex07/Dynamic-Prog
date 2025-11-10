// Given a string s of length n, find all the possible non-empty subsequences of the string s in lexicographically-sorted order.

import java.util.*;

class powerset {
    void generateSubsequences(String str, int index, String curr, List<String> result) {
        // Base case: if we've processed all characters
        if (index == str.length()) {
            // Add only non-empty subsequences
            if (!curr.isEmpty()) {
                result.add(curr);
            }
            return;
        }
        
        // Pick - include current character in subsequence
        generateSubsequences(str, index + 1, curr + str.charAt(index), result);
        
        // Not Pick - exclude current character from subsequence
        generateSubsequences(str, index + 1, curr, result);
    }
    
    public List<String> AllPossibleStrings(String s) {
        // Create list to store all subsequences
        List<String> result = new ArrayList<>();
        
        // Generate all subsequences using pick/not-pick strategy
        generateSubsequences(s, 0, "", result);
        
        // Sort the subsequences lexicographically
        Collections.sort(result);
        
        return result;
    }
}