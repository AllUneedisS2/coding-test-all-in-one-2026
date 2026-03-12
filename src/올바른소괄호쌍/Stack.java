package 올바른소괄호쌍;
import java.util.*;

public class Stack {

    public static void main (String[] args) {

        String input = "()()()()()()((()))";
        boolean result = solution(input);
        System.out.println(result);

    }

    static boolean solution(String input) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : input.toCharArray()) {

            if (c == '(') {
                stack.offerLast(c);
            } else {
                if (stack.peekLast() == null) return false;
                stack.pollLast();
            }

        }

        return true;
    }

}
