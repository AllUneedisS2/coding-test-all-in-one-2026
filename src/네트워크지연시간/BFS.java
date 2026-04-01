package 네트워크지연시간;

import java.util.*;
import java.util.stream.*;

public class BFS {

    public static void main(String args[]) {

        // 예시 1 — 기대: 4
        int[][] times1 = new int[][] {
                { 2, 1, 2 },
                { 2, 3, 5 },
                { 2, 4, 1 },
                { 4, 3, 3 }
        };
        int n1 = 4;
        int k1 = 2;
        System.out.println(bfs(times1, n1, k1));

        // 예시 2 — 기대: -1 (노드 1,2에 도달 불가)
        int[][] times2 = new int[][] {
                { 2, 1, 2 },
                { 2, 3, 5 },
                { 2, 4, 1 },
                { 4, 3, 3 }
        };
        int n2 = 4;
        int k2 = 4;
        System.out.println(bfs(times2, n2, k2));

        // 예시 3 (단일 체인) — 기대: 3
        int[][] times3 = new int[][] {
                { 1, 2, 1 },
                { 2, 3, 1 },
                { 3, 4, 1 }
        };
        int n3 = 4;
        int k3 = 1;
        System.out.println(bfs(times3, n3, k3));

        // 예시 4 (노간선, 한 노드) — 기대: 0
        int[][] times4 = new int[][] { };
        int n4 = 1;
        int k4 = 1;
        System.out.println(bfs(times4, n4, k4));

        // 예시 5 (불연결 컴포넌트) — 기대: -1
        int[][] times5 = new int[][] {
                { 1, 2, 1 },
                { 3, 4, 1 }
        };
        int n5 = 4;
        int k5 = 1;
        System.out.println(bfs(times5, n5, k5));

        // 예시 6 (다중 경로, 최단 경로가 우회로 더 빠른 경우) — 기대: 2
        int[][] times6 = new int[][] {
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 }
        };
        int n6 = 3;
        int k6 = 1;
        System.out.println(bfs(times6, n6, k6));

        // 예시 7 (사이클 있음) — 기대: 2
        int[][] times7 = new int[][] {
            { 1, 2, 1 },
            { 2, 3, 1 },
            { 3, 1, 1 }
        };
        int n7 = 3;
        int k7 = 1;
        System.out.println(bfs(times7, n7, k7));

        // 예시 8 (중간 경유로 도달 시간이 최댓값이 되는 케이스) — 기대: 5
        int[][] times8 = new int[][] {
                { 1, 2, 2 },
                { 1, 3, 5 },
                { 2, 3, 1 },
                { 2, 4, 2 },
                { 3, 5, 5 },
                { 4, 5, 1 }
        };
        int n8 = 5;
        int k8 = 1;
        System.out.println(bfs(times8, n8, k8));

        // 예시 9 (중복 간선, 더 작은 가중치 선택 필요) — 기대: 3
        int[][] times9 = new int[][] {
                { 1, 2, 5 },
                { 1, 2, 2 }, // 중복 간선, 이게 선택되어야 함
                { 2, 3, 1 }
        };
        int n9 = 3;
        int k9 = 1;
        System.out.println(bfs(times9, n9, k9));

        // 예시 10 (노들이 있지만 시작 노드 고립) — 기대: -1
        int[][] times10 = new int[][] { };
        int n10 = 3;
        int k10 = 2;
        System.out.println(bfs(times10, n10, k10));

    }

    static int bfs(int[][] times, int n, int k) {

        // 그래프로 변경 (인접 리스트)
        // 0 -> [0, 1, cost], [0, 2, cost], ...
        Map<Integer, List<int[]>> graph =Arrays.stream(times).collect(Collectors.groupingBy(t -> t[0]));

        // 각 노드까지의 계산된 costs
        // Map<노드, cost>
        Map<Integer, Integer> costs = new HashMap<>();

        // 다음 인접 노드를 순회하기 위한 방문한 노드 정보 예약 (우선순위큐)
        // int[노드, cost]
        // 단, cost가 작은 데이터를 우선순위로
        Queue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

        // 시작노드
        costs.put(k, 0);
        pq.add(new int[]{k, 0});

        // 우선순위 큐가 비어있지 않다면 계속
        while (!pq.isEmpty()) {

            // 현재 노드
            int[] cur = pq.remove();
            // 현재 노드값
            int curNode = cur[0];
            // 현재 노드 cost
            int curCost = cur[1];

            // 이미 등록된 cost의 값이 지금 계산된 값 보다 작다면 스킵
            if (costs.containsKey(curNode) && costs.get(curNode) < curCost) continue;

            // 인입 밖에 없는 노드인 경우
            if (!graph.containsKey(curNode)) continue;







            // 다음 인접 노드 탐색
            for (int[] nxt : graph.get(curNode)) {

                // 다음 노드까지 cost 계산
                int nxtCost = curCost + nxt[2];

                // 다음 노드의 cost가 등록되어 있지 않거나
                // 새롭게 계산된 cost가 기존의 cost 보다 작다면
                if (!costs.containsKey(nxt[1]) || nxtCost <= costs.get(nxt[1])) {
                    // cost 등록
                    costs.put(nxt[1], nxtCost);
                }
                
                // 다음 인접 노드를 위해 큐에 등록
                pq.add(new int[]{nxt[1], nxtCost});

            }





            
            
        }
        
        // costs의 size 값이 n과 같지 않다면 => 모든 노드 순회 X => return -1
        int costsSize = costs.size();
        if (costsSize != n) return -1;

        // costs의 value 값 중에서 가장 큰 값을 리턴
        return Collections.max(costs.values());
    }

    // https://velog.io/@d_hoonhoon_l/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Network-Delay-Time
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = Arrays.stream(times)
            .collect(Collectors.groupingBy(t -> t[0]));
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.add(new int[]{ k, 0 });
        visited[k] = 0;

        int maxTime = 0;
        int visitCount = 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0], time = cur[1];
            if (visited[u] < time) continue;
            maxTime = time;

            if (!edges.containsKey(u)) continue;
            for (int[] edge : edges.get(u)) {
                int v = edge[1], w = edge[2];
                if (time + w >= visited[v]) continue;

                if (visited[v] == Integer.MAX_VALUE) visitCount++;
                visited[v] = time + w;
                pq.add(new int[]{ v, time + w });
            }
        }

        return visitCount == n ? maxTime : -1;
    }

}
