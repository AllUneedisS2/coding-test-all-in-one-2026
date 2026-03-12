package 무료행사;
import java.util.*;

public class Hashmap {

    public static void main(String[] args) {

        int[] intA = {4, 3, 2, 5, 1};
        int target = 7;
        int result = solution(intA, target);
        System.out.println(result);

    }

    public static int solution(int[] prices, int target) {

        Set<Integer> hash = new HashSet<>();
        int count = 0;

        for (int i : prices) {

            int need = target - i;

            if (hash.contains(need)) {
                count++;
                continue;
            } else {
                hash.add(i);
            }
            
        }

        return count;
    }
    
    
}
