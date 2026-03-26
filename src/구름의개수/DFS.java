package 구름의개수;

public class DFS {

    // deltaRow
    static int[] dr = new int[] { 1, 0, -1, 0 };
    // deltaColumn
    static int[] dc = new int[] { 0, 1, 0, -1 };

    // 3
    static int[][] sky = new int[][] {
                { 0, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 }
    };

    // row
    static int n = sky.length;
    // column
    static int m = sky[0].length;

    public static void main(String[] args) {
        System.out.println(solution(sky));
    }

    static int solution(int[][] sky) {

        int count = 0;

        // visited 생성
        boolean[][] visited = new boolean[n][m];

        for (int r = 0 ; r < n ; r++) {
            for (int c = 0 ; c < m ; c++) {
                // 1인지 확인
                if (sky[r][c] == 1) {
                    // visited 확인
                    if (!visited[r][c]) {
                        dfs(r, c, visited);
                        // 네트워크 카운트
                        count++;
                    }                    
                }
            }
        }

        return count;
    }

    static void dfs(int r, int c, boolean[][] visited) {

        for (int i = 0 ; i < 4 ; i++) {

            int cr = r + dr[i];
            if (cr < 0 || cr >= n) continue; // sky 범위 안으로 제약
            int cc = c + dc[i];
            if (cc < 0 || cc >= m) continue; // sky 범위 안으로 제약

            if (sky[cr][cc] == 1 && !visited[cr][cc]) {
                visited[cr][cc] = true;
                dfs(cr,cc,visited);
            }
            
        }
    }

}
