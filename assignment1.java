// Print N-bit Binary Numbers having more 1s than 0s 
// Objective: Generate all binary strings of length N such that, at any prefix, the number of 1’s 
// is never less than the number of 0’s.
import java.util.*;

public class assignment1 {
    // helper method to do the job
    static void helper(String str, String curr, int index, List<String> result) {
        // base case
        if (index == str.length()) {
            int count1 = 0;
            int count0 = 0;

            for (char c : curr.toCharArray()) {
                if (c == '1') count1++;
                else count0++;
            }
            
            if (count1 >= count0) {
                result.add(curr);
            }
            
            return;
        }

        // recursive calls
        helper(str, curr + '1', index + 1, result);
        helper(str, curr + '0', index + 1, result);
    }

    public static void main(String[] args) {
        int N = 3;
        List<String> result = new ArrayList<>();

        int deci = (int) Math.pow(2, N) - 1;
        String bin = Integer.toBinaryString(deci);

        helper(bin, "", 0, result);

        System.err.println(result);
    }
}