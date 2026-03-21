package 태어난김에세계일주1;

public class Permutation {
    
    public static void main(String[] args) {
        
        int balance = 600;
        int[][] countries = {{70, 350}, {100, 550}, {350, 400}};
        
        int result = solution(balance, countries);

        System.out.println(result);

    }

    private static int solution(int balance, int[][] countries) {

        int n = countries.length;
        boolean[] visited = new boolean[n];
        
        // 깊이 우선 탐색 + 순열 + BF
        return dfs(balance, countries, 0, visited);

    }

    private static int dfs(int balance, int[][] countries, int count, boolean[] visited) {

        if 


        return 0;
    }


}
