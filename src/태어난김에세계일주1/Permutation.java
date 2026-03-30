package 태어난김에세계일주1;

public class Permutation {
    
    public static void main(String[] args) {
        
        int balance = 600;
        int[][] countries = {{70, 350}, {100, 550}, {350, 400}};
        
        int result = solution(balance, countries);

        System.out.println(result);

    }

    private static int result = 0;

    private static int solution(int balance, int[][] countries) {

        int n = countries.length;
        // 방문 체크 배열 생성
        boolean[] visited = new boolean[n];
        
        // 깊이 우선 탐색 + 순열 + BF
        dfs(balance, countries, 0, visited);

        return result;
    }

    private static void dfs(int balance, int[][] countries, int count, boolean[] visited) {

        result = Math.max(result, count);

        // 최대 여행지 방문 가능 수 만큼 순회
        for (int i = 0 ; i < countries.length ; i++) {

            // 이전에 방문하지 아니하였고,
            // 방문 가능한 필요 잔고보다 현재 잔고가 많다면,
            // 방문한다
            if(!visited[i] && balance >= countries[i][1]) {
                // 방문 횟수 및 해당 여행지 visited true
                count++;
                visited[i] = true;
                // 다음 방문지 순회
                dfs(balance - countries[i][0], countries, count, visited);
                // 백트래킹
                count--;
                visited[i] = false;
            }

        }

    }


}
