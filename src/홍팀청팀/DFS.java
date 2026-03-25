package 홍팀청팀;
import java.util.*;

public class DFS {

    public static void main(String[] args) {
        
        int[][] friends1 = new int[][]{{1},{2},{0}}; //false
        int[][] friends2 = new int[][]{{1,2},{0,3},{0},{1}}; //true

        System.out.println(solution(friends1));

    }

    private static boolean solution(int[][] friends) {

        int n = friends.length;
        int[] colors = new int[n];
        // 일단 전부 팀 지정이 안된 상태인 -1로 변경해주고
        Arrays.fill(colors, -1);
        // 각 노드 마다 colors를 임의로 지정해보면서 순회 및 dfs로 이분 그래프인지 체크
        for (int v = 0 ; v < n ; v++) {
            // 이미 순회가 끝난 경우는 패스해야하므로 colors가 -1인 노드만 dfs
            if (colors[v] == -1) {
                // 해당 노든는 0으로 임의 팀 지정
                colors[v] = 0;
                // dfs에서 false를 리턴하면 실패이므로 그대로 false 리턴
                if (!dfs(friends, v, colors)) {
                    return false;
                }
                
            }
            
        }
        // 순회가 끝날때까지 false 리턴이 아니라면 성공으로 true 리턴
        return true;
    }

    private static boolean dfs(int[][] friends, int cur, int[] colors) {

        // 친구(nxt)에 대해 순회 진행
        for (int nxt : friends[cur]) {
            
            // 친구가 나와 같은 팀이라면 false 리턴
            if (colors[nxt] == colors[cur]) {
                return false;
            }
            
            // 친구의 팀이 아직 정해지지 않았다면
            if (colors[nxt] == -1) {
                // 나와 다른 팀을 지정
                colors[nxt] = 1 - colors[cur];
                // 그리고 해당 친구를 cur로 다시 dfs 진행 및 false 리턴시 false 리턴
                if (!dfs(friends, nxt, colors)) {
                    return false;
                }
            }

            // 해당 친구의 팀이 나와 다르다면 다음 친구로

        }

        // 위의 순회를 무사히 종료했다면 true 리턴
        return true;

    }

}
