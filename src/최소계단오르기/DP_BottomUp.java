package 최소계단오르기;

public class DP_BottomUp {

    public static void main(String[] args) {
        // f(n)             => 도착지점 n까지의 최소값 cost
        // f(n) + cost(n)   => 도착지점 n까지의 최소값 cost에서 계단을 한 번 더 이동했을때의 총 cost
        // 최종 도착지점을 n이라고 했을때
        // 직전 도착지점은 반드시 n-2이거나 n-1이다
        // 때문에, f(n) = min( f(n-2)+cost(n-2), f(n-1)+cost(n-1) )

        int[] cost1 = new int[]{10,15,20}; // 15
        int[] cost2 = new int[]{1,100,1,1,1,100,1,1,100,1}; // 6

        System.out.println(dp(cost1));
        System.out.println(dp(cost2));
    }

    static int dp(int[] cost) {

        int n = cost.length;

        // dp 테이블 생성
        // 배열의 마지막 index는 n-1인데,
        // 최종 도착지점은 n이어야 하므로,
        // 배열의 마지막 index를 n으로 맞추기 위해 +1
        int[] dp = new int[cost.length + 1];

        // 0또는 1에서 시작가능하다 하였으므로
        dp[0] = 0;
        dp[1] = 0;

        // 두 번째 계단에 오르기 위해서 0 또는 1 번째 계단의 코스트를 사용하며...
        // bottom up 시작
        for (int i = 2 ; i <= cost.length ; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        // 결과
        return dp[n];
    }
    
}
