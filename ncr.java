import java.util.*;

public class ncr {
    // Memoization map: key is "n,r"
    private static final Map<String, Integer> memo = new HashMap<>();

    public int nCr(int n, int r) {
        // Handle invalid cases
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r == 1) return n;

        // Create a unique key for (n, r)
        String key = n + "," + r;

        // Check memoized result
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive formula: nCr = (n-1 C r-1) + (n-1 C r)
        int result = nCr(n - 1, r - 1) + nCr(n - 1, r);

        // Store in memo
        memo.put(key, result);

        return result;
    }
}