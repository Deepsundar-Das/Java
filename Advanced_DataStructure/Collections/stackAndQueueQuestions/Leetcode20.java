import java.util.*;

class Leetcode20 {

    public static void main(String[] args) {
        String s = "(((){))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stak = new Stack<>();
        char[] sArr = s.toCharArray();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char popedItem = '\0';
            if (sArr[i] == '(' || sArr[i] == '[' || sArr[i] == '{') {
                stak.push(sArr[i]);
            } else {
                if (!stak.isEmpty()) popedItem = stak.pop();
                else return false;
            }

            if (popedItem == '(' && sArr[i] != ')') return false;
            else if (popedItem == '{' && sArr[i] != '}') return false;
            else if (popedItem == '[' && sArr[i] != ']') return false;

            i++;
        }
        return stak.isEmpty();
    }
}
