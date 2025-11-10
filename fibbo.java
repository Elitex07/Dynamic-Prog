public class fibbo {
    
    // Wrapper class to simulate pass by reference for counter
    static class Counter {
        int value;
        Counter(int value) {
            this.value = value;
        }
    }
    
    public static int fibonacci(int n, Counter counter) {
        // increment function call counter
        counter.value++;
        
        // base cases
        if (n <= 1) {
            return n;
        }
        
        // recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n-1, counter) + fibonacci(n-2, counter);
    }
    
    public static void main(String[] args) {
        int n = 10;  // calculate 10th fibonacci number
        Counter counter = new Counter(0);
        
        int result = fibonacci(n, counter);
        
        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Function was called " + counter.value + " times");
        
        // Print first n+1 fibonacci numbers
        System.out.println("\nFirst " + (n+1) + " Fibonacci numbers:");
        for (int i = 0; i <= n; i++) {
            Counter c = new Counter(0);
            System.out.print(fibonacci(i, c) + " ");
        }
        System.out.println();
    }
}
