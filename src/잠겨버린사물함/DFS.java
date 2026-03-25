package 잠겨버린사물함;
import java.util.*;

public class DFS {

    static int result = 0;

    public static void main(String[] args) {

        // 0
        int[][] lockers1 = new int[][]{{1,2},{3},{},{0}};

        // 1
        int[][] lockers2 = new int[][]{{1,3},{2,4},{0},{4},{},{3,4}};

        // 2
        int[][] lockers3 = new int[][]{{0,1},{0,1},{2,3},{2,3}};

        solution(lockers3);

    }

    private static void solution(int[][] lockers) {
        int n = lockers.length;
        boolean[] visited = new boolean[n];
        dfs(lockers, 0, visited);
        System.out.println(n - result);
    }

    private static void dfs(int[][] lockers, int start, boolean[] visited) {
        result++;
        visited[start] = true;
        for (int node : lockers[start]) {
            if (!visited[node]) {
                dfs(lockers, node, visited);
            }
        }
    }

}
