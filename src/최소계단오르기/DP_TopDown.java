package 최소계단오르기;
import java.util.*;

public class DP_TopDown {

    public static void main(String[] args) {
        // f(n)             => 도착지점 n까지의 최소값 cost
        // f(n) + cost(n)   => 도착지점 n까지의 최소값 cost에서 계단을 한 번 더 이동했을때의 총 cost
        // 최종 도착지점을 n이라고 했을때
        // 직전 도착지점은 반드시 n-2이거나 n-1이다
        // 때문에, f(n) = min( f(n-2)+cost(n-2), f(n-1)+cost(n-1) )

        int[] cost1 = new int[]{10,15,20}; // 15
        int[] cost2 = new int[]{1,100,1,1,1,100,1,1,100,1}; // 6

        System.out.println(solution(cost1));
        System.out.println(solution(cost2));
    }

    static int solution(int[] cost) {

        int n = cost.length;

        // 배열의 마지막 index는 n-1인데,
        // 최종 도착지점은 n이어야 하므로,
        // 배열의 마지막 index를 n으로 맞추기 위해 +1
        int[] memo = new int[n+1];

        // 지정되지 않은 경우 -1로
        Arrays.fill(memo, -1);

        return dp(cost, n, memo);
    }

    static int dp(int[] cost, int n, int[] memo) {
        
        // 0또는 1에서 시작가능하다 하였으므로
        if (n == 0 || n == 1) {
            return 0;
        }

        // 지정된 memo[n]이 아니라면 계산하여 지정
        else if (memo[n] == -1) {
            memo[n] = Math.min(dp(cost, n-2, memo) + cost[n-2], dp(cost, n-1, memo) + cost[n-1]);
        }

        // 결과
        return memo[n];
    }
    
}
