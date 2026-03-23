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
        boolean[] visited = new boolean[n];
        
        // 깊이 우선 탐색 + 순열 + BF
        dfs(balance, countries, 0, visited);

        return result;
    }

    private static void dfs(int balance, int[][] countries, int count, boolean[] visited) {

        result = Math.max(result, count);

        for (int i = 0 ; i < countries.length ; i++) {

            // 방문 O
            if(!visited[i] && balance >= countries[i][1]) {
                count++;
                visited[i] = true;
                dfs(balance - countries[i][0], countries, count, visited);
                count--;
                visited[i] = false;
            }

        }

    }


}
