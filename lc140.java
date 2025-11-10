import java.util.*;

class Solution {
    Map<String, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        this.memo = new HashMap<>();
        
        return backtrack(s, wordSet);
    }
    private List<String> backtrack(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> results = new ArrayList<>();

        // 2. Base Case
        if (s.isEmpty()) {
            results.add(""); // This signals a valid end.
            return results;
        }

        // 3. Recursive / Backtracking Step
        // Try every possible prefix of the current string 's'.
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            // Check if this prefix is a valid word in our dictionary.
            if (wordSet.contains(prefix)) {
                
                // If it is, this prefix is a valid "first word".
                // Now, recursively find all possible sentences for the *rest* of the string.
                String remainingString = s.substring(i);
                List<String> suffixSentences = backtrack(remainingString, wordSet);

                // Now, combine our 'prefix' with every valid 'suffixSentence' found.
                for (String suffix : suffixSentences) {
                    if (suffix.isEmpty()) {
                        results.add(prefix);
                    } else {
                        results.add(prefix + " " + suffix);
                    }
                }
            }
        }

        memo.put(s, results);
        return results;
    }
}