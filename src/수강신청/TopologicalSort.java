package 수강신청;
import java.util.*;
public class TopologicalSort {

    public static void main(String[] args) {

        // 1) 간단한 선행관계
        int numCourses1 = 2;
        int[][] prerequisites1 = { {1, 0} };

        // 2) 바로 사이클 (불가능)
        int numCourses2 = 2;
        int[][] prerequisites2 = { {1, 0}, {0, 1} };

        // 3) 분기된 선행관계 (여러 올바른 해가 있음)
        int numCourses3 = 4;
        int[][] prerequisites3 = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };

        // 4) 코스 하나, 선행 없음
        int numCourses4 = 1;
        int[][] prerequisites4 = { };

        // 5) 일부만 사이클인 경우
        int numCourses5 = 3;
        int[][] prerequisites5 = { {1,0}, {1,2}, {0,1} }; // 0<->1 사이클 포함

        // 6) 체인 형태 + 분기
        int numCourses6 = 5;
        int[][] prerequisites6 = { {1,0}, {2,0}, {3,1}, {3,2}, {4,3} };

        // 7) 중복 간선 존재
        int numCourses7 = 3;
        int[][] prerequisites7 = { {1,0}, {1,0}, {2,1} };

        // 8) 비연결 컴포넌트(여러 독립 서브그래프)
        int numCourses8 = 6;
        int[][] prerequisites8 = { {2,0}, {2,1}, {4,3} };

        System.out.println(solution(numCourses1, prerequisites1)); // true
        System.out.println(solution(numCourses2, prerequisites2)); // false
        System.out.println(solution(numCourses3, prerequisites3)); // true
        System.out.println(solution(numCourses4, prerequisites4)); // true
        System.out.println(solution(numCourses5, prerequisites5)); // false
        System.out.println(solution(numCourses6, prerequisites6)); // true
        System.out.println(solution(numCourses7, prerequisites7)); // true
        System.out.println(solution(numCourses8, prerequisites8)); // true

    }

    static boolean solution(int numCourses, int[][] prerequisites) {

        // 인접리스트 생성
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 각 노드별 indegree 설정
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites) {
            // 인접리스트 변경
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
            // indegree 설정 (해당 노드로 인입되는 노드의 갯수)
            indegree[edge[0]]++;
        }

        // 정렬 결과들을 순서대로 넣을 큐 생성
        Queue<Integer> queue = new ArrayDeque<>();

        // 방문기록 생성
        boolean[] visited = new boolean[numCourses];
        
        // 방문 카운트
        int count = 0;

        // 초기에 indegree가 0인 노드 탐색 (초기 설정)
        for (int i = 0 ; i < numCourses ; i++) {
            if (indegree[i] == 0) {
                // 방문
                visited[i] = true;
                // 큐에 넣기
                queue.add(i);
                // 방문 카운트 +1
                count++;
            }
        }

        // 초기 방문 노드로 순회 시작
        // 초기 노드가 없다면 자동으로 return false
        while (!queue.isEmpty()) {
            // 현재 노드 설정
            int cur = queue.remove();
            if (graph.containsKey(cur)) {
                for (int nxt : graph.get(cur)) {
                    // 현재 노드에 존재하는 다음 노드들의 indegree 값 -1
                    indegree[nxt]--;
                    // indegree 값이 0이 됐다면
                    if (indegree[nxt] == 0) {
                        // 방문
                        visited[nxt] = true;
                        // 큐에 넣기
                        queue.add(nxt);
                        // 방문 카운트 +1
                        count++;
                    }
                }
            }
        }
        
        // 방문 카운트와 모든 강의 수가 같다면 true
        return count == numCourses;

    }

}
