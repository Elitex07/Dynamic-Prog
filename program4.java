public class program4 {
    
    // recursive method to check if string contains only digits
    // returns true if str[start..end] contains only digits
    public static boolean isAllDigits(String str, int index) {
        // base case: if we've checked all characters
        if (index >= str.length()) {
            return true;
        }
        
        // check if current character is a digit
        if (!Character.isDigit(str.charAt(index))) {
            return false;
        }
        
        // recursively check rest of the string
        return isAllDigits(str, index + 1);
    }
    
    // wrapper method for easier use
    public static boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // empty or null strings are not considered valid digit strings
        }
        return isAllDigits(str, 0);
    }

    public static void main(String[] args) {
        // test cases
        String[] tests = {
            "123456",      // true
            "12.34",       // false (contains decimal)
            "9876543210",  // true
            "123abc",      // false (contains letters)
            "0",          // true
            " 123",       // false (contains space)
            "-123"        // false (contains minus)
        };

        if (args.length > 0) {
            // if command line argument provided, test that string
            String test = args[0];
            System.out.println("Testing string: \"" + test + "\"");
            System.out.println("Contains only digits: " + isAllDigits(test));
        } else {
            // run all test cases
            System.out.println("Running test cases:");
            for (String test : tests) {
                System.out.println("String: \"" + test + "\"");
                System.out.println("Contains only digits: " + isAllDigits(test));
                System.out.println();
            }
        }
    }
}
