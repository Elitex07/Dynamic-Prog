// Delete Middle Element of a Stack using Recursion
// Objective: Remove the middle element from a stack without using loops or extra data 
// structures
import java.util.*;

public class assignment2 {
    static void helper(Stack<Integer> stack, int count, int size) {
        // base case
        if (stack.isEmpty()) return;

        // recursive call
        int num = stack.pop();
        helper(stack, count + 1, size);

        if (count != size / 2) {
            stack.push(num);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int size = stack.size();
        helper(stack, 0, size);
        System.err.println(stack);
    }
}
