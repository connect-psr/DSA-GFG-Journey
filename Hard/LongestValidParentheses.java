import java.util.Stack;

class Solution{
    static int maxLength(String S){
        Stack<Integer> stack = new Stack<>();
        
        stack.push(-1); // Initialize stack with -1 to handle edge cases
        
        int maxLenValidPara = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            if (ch == '(') {
                stack.push(i); // Push index of '(' onto stack
                
            } else {
                stack.pop(); // Pop the last '(' index
                
                if (!stack.isEmpty()) {
                    // Calculate the length of the valid parentheses substring
                    maxLenValidPara = Math.max(maxLenValidPara, i - stack.peek());
                    
                } else {
                    stack.push(i); // Push current index as the new base for valid parentheses
                }
            }
        }
        
        return maxLenValidPara;
    }
}

public class LongestValidParentheses {
    public static void main(String[] args) {
        // Test the solution
    }
}
