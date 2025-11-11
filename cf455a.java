import java.util.*;

public class cf455a {
    static long[] count;
    static long[] memo;
    static int maxNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        final int MAX = 100000;
        count = new long[MAX + 1];
        maxNum = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x >= 0 && x <= MAX) {
                count[x]++;
                if (x > maxNum) maxNum = x;
            }
        }

        // ensure at least size 2 for base indexing
        memo = new long[maxNum + 1 < 2 ? 2 : maxNum + 1];
        Arrays.fill(memo, -1L);

        System.out.println(solve(maxNum));
        sc.close();
    }

    private static long solve(int i) {
        if (i <= 0) return 0L;
        if (i == 1) return count[1];
        if (memo[i] != -1L) return memo[i];

        long skip = solve(i - 1);
        long take = solve(i - 2) + (long)i * count[i];
        memo[i] = Math.max(skip, take);
        return memo[i];
    }
}