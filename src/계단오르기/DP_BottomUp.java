package 계단오르기;

public class DP_BottomUp {

    public static void main(String[] args) {
        // f(n) = f(n-2) + f(n-1)
        int n1 = 4; // 5
        int n2 = 6; // 13

        System.out.println(dp(n1));
        System.out.println(dp(n2));
    }

    static int dp(int n) {
        // 목표 계단 수의 dp 테이블
        int[] dp = new int[n+1];

        // 0번째, 1번째 계단을 1로 지정 (초기값 설정)
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];

    }
    
}
