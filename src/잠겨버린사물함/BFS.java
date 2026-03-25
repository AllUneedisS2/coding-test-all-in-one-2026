package 잠겨버린사물함;
import java.util.*;

public class BFS {

    static int result = 0;

    public static void main(String[] args) {

        // 0
        int[][] lockers1 = new int[][]{{1,2},{3},{},{0}};

        // 1
        int[][] lockers2 = new int[][]{{1,3},{2,4},{0},{4},{},{3,4}};

        // 2
        int[][] lockers3 = new int[][]{{0,1},{0,1},{2,3},{2,3}};

        solution(lockers3);

        System.out.println(result);

    }

    private static void solution(int[][] lockers) {
        int n = lockers.length;
        // 순회한 노드에 대한 체크
        boolean[] visited = new boolean[n];
        bfs(lockers, 0, visited);

    }

    private static void bfs(int[][] lockers, int start, boolean[] visited) {

        // 노드에 대한 필요한 정보들을 담는 큐
        // 다음으로 어떤 노드의 간선들을 순회할지 담는 큐
        Deque<Integer> q = new ArrayDeque<>();

        // 첫 노드의 방문 체크
        visited[start] = true;
        // 첫 노드의 간선들을 순회하기 위해 추가
        q.add(start);

        // 모든 노드를 순회할때까지
        while (!q.isEmpty()){
            // 다음의 노드 꺼내기
            int cur = q.removeFirst();
            // 해당 노드의 간선 노드들을 순회
            for (int nxt : lockers[cur]) {
                // 간선 노드들에 대한 방문 여부 체크,
                // 이미 방문했다면 스킵
                if (!visited[nxt]) {
                    // 간선 노드에 대한 방문 체크
                    visited[nxt] = true;
                    // 해당 간선 노드의 또 다른 간선 노드들을 순회하기 위해 추가
                    q.add(nxt);
                }
            }
        }

        for (boolean chk : visited) {
            if (!chk) result++;
        }

    }

}
