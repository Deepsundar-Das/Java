import java.util.*;

class Leetcode32 {

    public static void main(String[] args) {
        String s = "";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        int count = 0;
        char[] sArr = s.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            if (sArr[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    max = Math.max(count, max);
                    count = 0;
                    // continue;
                } else {
                    stack.pop();
                    count += 2;
                }
            }
            i++;
        }
        return Math.max(max, count);
    }
}
