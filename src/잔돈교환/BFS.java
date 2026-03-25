package 잔돈교환;
import java.util.*;

public class BFS {

    public static void main(String[] args) {
        
        // output: 3
        int[] coins1 = new int[]{9,4,1};
        int amount1 = 12;
        
        // output: 2
        int[] coins2 = new int[]{10,5, 25, 1};
        int amount2 = 30;

        System.out.println(solution(coins1, amount1));
        System.out.println(solution(coins2, amount2));

    }

    // 첫 노드의 값을 0으로 시작해서 각 코인들을 더해보며 amount가 되는 노드까지의 최단거리 (BFS 사용)
    // 하지만 제약 설정내의 코인의 최댓값이 2^31-1이기 때문에,
    // 첫 노드의 값을 0으로 시작하여 더하다보면 Integer overflow가 발생할 수 있으니,
    // 첫 노드의 값을 amount로 하자
    private static int solution(int[] coins, int amount) {

        // 노드에 대한 필요한 정보를 담는 큐
        // {현재 amount, 동전 사용 횟수}
        Deque<int[]> queue = new ArrayDeque<>();

        // 방문한 노드는 스킵하기 위해 담아두는 셋
        // 이미 방문한 N 노드가 0 노드까지 도달하는 길이는,
        // 후에 방문된 N 노드가 0 노드까지 도달하는 길이보다 무조건 짧다
        // BFS이기 때문에 가능
        Set<Integer> visited = new HashSet<>();
        
        // 초기 설정
        int[] start = new int[]{amount, 0};
        queue.add(start);

        // 이제 순회
        while(!queue.isEmpty()) {

            // 일단 큐의 가장 앞에꺼 꺼내기
            int[] cur = queue.removeFirst();

            int curAmount = cur[0];
            int nxtCount = cur[1] + 1;

            // 동전 순회
            for (int coin : coins) {

                // 현재 amount에 코인 빼기
                int nxtAmount = curAmount - coin;
                
                // 다음 amount가 음수이거나 이미 방문했던 노드라면 스킵
                if (nxtAmount < 0 || visited.contains(nxtAmount)) {
                    continue;
                }

                // 다음 amount가 0이라면 curCount + 1 => 정답
                if (nxtAmount == 0) {
                    return nxtCount;
                }

                // 다음 amount가 아직 양수라면 계속 진행
                // 다음에 nxtAmount 값으로 다시 계산하기 위해 큐에 저장
                queue.add(new int[]{nxtAmount, nxtCount});
                // 이번 순회에서 계산된 nxtAmount 값은 셋에 저장
                visited.add(nxtAmount);
                
            }

        }

        return -1;
    }

}
