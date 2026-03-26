package 응급차최단거리;

import java.util.*;

public class BFS {

    static int[][] city = new int[][]{
        {0,1,0},
        {0,1,0},
        {0,0,0},
        {1,1,0},
        {0,0,0}
    };

    // Row
    static int n = city.length;
    // Column
    static int m = city[0].length;

    // Delta Row
    static int[] dr = new int[]{1,0,-1,0,1,1,-1,-1};
    // Delta Column
    static int[] dc = new int[]{0,1,0,-1,1,-1,1,-1};

    public static void main(String[] args) {
        System.out.println(solution(city));
    }

    static int solution(int[][] city) {

        // 다음 순회 노드 정보
        Queue<int[]> q = new ArrayDeque<>();
        
        // 초기 노드 생성
        int[] start = new int[]{0, 0};
        
        // visited 생성
        int[][] visited = new int[n][m];

        // 초기 설정
        visited[0][0] = 1;
        q.add(start);

        // bfs
        while (!q.isEmpty()) {

            int[] cn = q.remove();
            int cr = cn[0];
            int cc = cn[1];
            
            // 도착했다면 return
            if (cr == n-1 && cc == m-1) return visited[cr][cc];

            for (int i = 0 ; i < 8 ; i++) {

                // city 안의 배열 확인
                int nr = cr + dr[i];
                if (nr < 0 || nr >= n) continue;
                int nc = cc + dc[i];
                if (nc < 0 || nc >= m) continue;

                // 도로인지 확인
                if (city[nr][nc] == 1) continue;

                // visited 확인
                if (visited[nr][nc] == 0) {
                    // 방문 true
                    visited[nr][nc] = visited[cr][cc] + 1;
                    // 다음 노드 저장
                    q.add(new int[]{nr, nc});
                }

            }
        }

        return -1;
    }
    
}
