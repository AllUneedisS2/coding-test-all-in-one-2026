package FreeSale;
import java.util.*;

public class Sort {

    public static void main (String[] args) {

        int[] intA = {4, 3, 2, 5, 1};
        int target = 7;
        int result = solution(intA, target);
        System.out.println(result);

    }
    



    public static int solution(int[] prices, int target) {
    
        Arrays.sort(prices);

        int l = 0;
        int r = prices.length - 1;
        int count = 0;

        while (l < r) {

            int result = prices[l] + prices[r];

            if (result == target) {
                count++;
                l++;
                r--;
                continue;
            }

            if (result < target) {
                l++;
            } else {
                r--;
            }

        }

        return count;
    
    }



}