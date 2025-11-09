import java.util.*;

public class movebrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(minMovesToRegularBracketSequence(s));
        }
        sc.close();
    }

    public static int minMovesToRegularBracketSequence(String s) {
        return backtrack(s.toCharArray(), 0);
    }
    
    private static int backtrack(char[] brackets, int moves) {
        if (isRegularSequence(new String(brackets))) {
            return moves;
        }
        
        if (moves >= brackets.length) {
            return Integer.MAX_VALUE;
        }
        
        int minMoves = Integer.MAX_VALUE;
        
        for (int i = 0; i < brackets.length; i++) {
            // Try moving bracket to start
            char[] startMove = moveToStart(brackets, i);
            int startResult = backtrack(startMove, moves + 1);
            if (startResult < minMoves) {
                minMoves = startResult;
            }
            
            // Try moving bracket to end
            char[] endMove = moveToEnd(brackets, i);
            int endResult = backtrack(endMove, moves + 1);
            if (endResult < minMoves) {
                minMoves = endResult;
            }
        }
        
        return minMoves;
    }
    
    private static char[] moveToStart(char[] brackets, int index) {
        char[] result = new char[brackets.length];
        result[0] = brackets[index];
        int j = 1;
        for (int i = 0; i < brackets.length; i++) {
            if (i != index) {
                result[j++] = brackets[i];
            }
        }
        return result;
    }
    
    private static char[] moveToEnd(char[] brackets, int index) {
        char[] result = new char[brackets.length];
        int j = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (i != index) {
                result[j++] = brackets[i];
            }
        }
        result[brackets.length - 1] = brackets[index];
        return result;
    }
    
    private static boolean isRegularSequence(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
