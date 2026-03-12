package 점진적과부화;
import java.util.*;

public class MonotonicStack {

    public static void main(String[] args) {

        int[] input = {45,42,50,48,46,52,49};
        int[] result = solution(input);

        System.out.print("{");
        for (int i = 0 ; i < input.length ; i++) {
            System.out.print(result[i]);
            if (i != input.length-1) System.out.print(", ");
        }
        System.out.print("}");


    }

    private static int[] solution(int[] input) {

        int[] result = new int[input.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for (int curDay = 0 ; curDay < input.length ; curDay++) {
        
            int curWeight = input[curDay];

            // 현재 웨이트값 보다 높은게 나올때까지 계속 꺼내고, 계산하고
            while (!stack.isEmpty() && stack.peek()[1] < curWeight) {
                int[] temp = stack.pollLast();
                result[temp[0]] = curDay - temp[0];
            }

            stack.offerLast(new int[]{curDay, input[curDay]});

        }

        return result;

    }


}