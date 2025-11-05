import java.util.Scanner;

public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long n = sc.nextLong();
        System.out.println("Number of digits: " + countDigits(n));
        sc.close();
    }

    static int countDigits(long n) {
        if (n == 0) return 1;
        if (n < 0) n = -n;
        // Call the recursive function
        return countDigitsRec(n);
    }

    // Recursive Function to count digits
    private static int countDigitsRec(long n) {
        if (n < 10) return 1;
        return 1 + countDigitsRec(n / 10);
    }
}
