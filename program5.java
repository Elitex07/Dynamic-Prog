public class program5 {
    
    // recursive method to count zeros in a number
    public static int countZeros(long n) {
        // handle negative numbers by converting to positive
        if (n < 0) {
            n = -n;
        }
        
        // base case: single digit
        if (n < 10) {
            return (n == 0) ? 1 : 0;
        }
        
        // if last digit is 0, add 1 to result of remaining digits
        if (n % 10 == 0) {
            return 1 + countZeros(n / 10);
        }
        
        // if last digit is not 0, just check remaining digits
        return countZeros(n / 10);
    }
    
    // overloaded method for String input
    public static int countZeros(String numStr) {
        try {
            return countZeros(Long.parseLong(numStr));
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + numStr);
            return -1;
        }
    }

    public static void main(String[] args) {
        // test cases
        long[] tests = {
            1000200,    // 4 zeros
            0,          // 1 zero
            123,        // 0 zeros
            100001,     // 4 zeros
            -10203,     // 2 zeros
            808,        // 1 zero
            10000      // 4 zeros
        };

        if (args.length > 0) {
            // if command line argument provided, test that number
            String numStr = args[0];
            System.out.println("Number: " + numStr);
            int zeros = countZeros(numStr);
            if (zeros >= 0) {
                System.out.println("Number of zeros: " + zeros);
            }
        } else {
            // run all test cases
            System.out.println("Running test cases:");
            for (long num : tests) {
                System.out.println("Number: " + num);
                System.out.println("Number of zeros: " + countZeros(num));
                System.out.println();
            }
        }
    }
}
