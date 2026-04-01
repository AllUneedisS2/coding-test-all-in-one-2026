package 계단오르기;
import java.util.*;

// TopDown도 결국에는 계산을 아래서부터 완료돼야 하는건데..
// 왜 TopDown이라고 하는거지... 잘 이해는 안되지만...
// 어쨌든 위에서 부터 계산 요청이 내려가니까... 뭐...ㅎㅎ...
class DP_TopDown {
    public static void main(String[] args) {
        // f(n) = f(n-2) + f(n-1)
        int n1 = 4; // 5
        int n2 = 6; // 13

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }

    static int solution(int n) {
        // 목표 계단 수의 memo 생성
        int[] memo = new int[n+1];
        
        // -1로 초기화
        Arrays.fill(memo, -1);

        // 재귀 dp
        return dp(memo, n);
    }

    static int dp(int[] memo, int n) {
        // f(0) or f(1)인 경우는 1로 반환
        if (n == 0 || n == 1) {
            return 1;
        }
        // 현재 memo[n]이 지정되어 있지 않다면
        else if (memo[n] == -1) {
            memo[n] = dp(memo, n-2) + dp(memo, n-1);
        }

        // 결과
        return memo[n];
    }
}