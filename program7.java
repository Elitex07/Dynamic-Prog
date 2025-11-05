public class program7 {
    static int reversed = 0;
    static int digits = 0;
    
    public static int reverseNumber(int n) {
        if (n == 0) {
            return reversed;
        }
        
        int digit = n % 10;
        reversed = reversed * 10 + digit;
        return reverseNumber(n / 10);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Number: " + n);
        System.out.println("Reversed: " + reverseNumber(n));
    }
}
