public class program6 {
    
    // recursive method to convert decimal to binary
    public static void decimalToBinary(int n) {
        // base case
        if (n == 0) {
            return;
        }
        
        // recursive call before print for correct order
        decimalToBinary(n / 2);
        System.out.print(n % 2);
    }
    
    public static void main(String[] args) {
        int n = 13;  // example number to convert
        System.out.print("Binary of " + n + " is: ");
        if (n == 0) {
            System.out.print("0");
        } else {
            decimalToBinary(n);
        }
    }
}
