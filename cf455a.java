import java.util.*;

public class cf455a {
    static long[] dp;
    static long[] count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        count = new long[100001];
        
        // Count frequencies
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            count[x]++;
        }
        
        // Initialize dp array
        dp = new long[100001];
        dp[0] = 0;
        dp[1] = count[1];
        
        // Fill dp array iteratively
        for(int i = 2; i <= 100000; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + i * count[i]);
        }
        
        System.out.println(dp[100000]);
        sc.close();
    }
}
