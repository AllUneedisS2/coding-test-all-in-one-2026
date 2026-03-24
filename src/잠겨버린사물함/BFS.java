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
        boolean[] visited = new boolean[n];
        bfs(n, lockers, 0, visited);

    }

    private static void bfs(int n, int[][] lockers, int start, boolean[] visited) {

        Deque<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()){
            int cur = q.removeFirst();
            for (int nxt : lockers[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        for (boolean chk : visited) {
            if (!chk) result++;
        }

    }


    
}
