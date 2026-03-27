package 감염된폴더;
import java.util.*;

public class DFS {

    public static void main(String[] args) {
        
        String[][] folders1 = new String[][]{
            {"root","apps"},
            {"apps","chrome"},
            {"apps","vscode"}
        };
        String p1 = "chrome";
        String q1 = "vscode";

        String[][] folders2 = new String[][]{
            {"root","media"},
            {"media","images"},
            {"media","videos"},
            {"images","holiday"},
            {"videos","concert"}
        };
        String p2 = "media";
        String q2 = "concert";

        String[][] folders3 = new String[][]{
            {"root","media"},
            {"media","images"},
            {"media","videos"},
            {"videos","concert"},
            {"concert","holiday"},
        };
        String p3 = "concert";
        String q3 = "holiday";

        System.out.println(solution(folders1, p1, q1)); // apps
        System.out.println(solution(folders2, p2, q2)); // midea
        System.out.println(solution(folders3, p3, q3)); // concert

    }

    private static String solution(String[][] folders, String p, String q) {

        // 간선리스트 => 인접리스트(tree)
        Map<String, List<String>> tree = new HashMap<>();
        for (String[] edge : folders) {
            String parent = edge[0];
            String child = edge[1];
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        return dfs(tree, "root", p, q);

    }

    private static String dfs(Map<String,List<String>> tree, String node, String p, String q) {

        List<String> infected = new ArrayList<>();

        if (node.equals(p) || node.equals(q)) {
            infected.add(node);
        }

        for (String nextNode : tree.getOrDefault(node, new ArrayList<>())) {
            String result = dfs(tree, nextNode, p, q);
            if (result != null) infected.add(result);
        }

        int infectedSize = infected.size();

        if (infectedSize == 1) return infected.get(0);
        if (infectedSize == 2) return node;

        return null;

    }
    
    // 끝까지 안가도 가능한 경우
    // root까지 올린것이 하나밖에 없다면 그냥 그게 정답 (밑에 깔려있는게 확실시됨)
    private static String dfsLecture(Map<String,List<String>> tree, String node, String p, String q) {
        
        if (node.equals(p) || node.equals(q)) {
            return node;
        }
        List<String> found = new ArrayList<>();
        List<String> children = tree.getOrDefault(node, new ArrayList<>());
        for (String child : children) {
            String res = dfs(tree, child, p, q);
            if (res != null) {
                found.add(res);
            }
        }
        if (found.size() == 2) return node;
        if (found.size() == 1) return found.get(0);

        return null;

    }

}
