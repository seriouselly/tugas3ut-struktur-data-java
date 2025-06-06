import java.util.*;

public class DepthFirstSearch {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        graph.put("a1", Arrays.asList("a2", "a3"));
        graph.put("a2", Arrays.asList("a3", "a4"));
        graph.put("a3", Arrays.asList("a4", "a5"));
        graph.put("a4", Arrays.asList("a5", "a6"));
        graph.put("a5", Arrays.asList("a6"));
        graph.put("a6", Arrays.asList("a7"));
        graph.put("a7", Collections.emptyList());

        String target = "a7";
        System.out.println("Proses pencarian DFS: ");
        dfs("a1", target);
    }

    public static void dfs(String node, String target) {
        System.out.println("Mengunjungi: " + node);
        if (node.equals(target)) {
            System.out.println("Node " + target + " ditemukan!");
            return;
        }

        visited.add(node);

        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, target);
            }
        }
    }
}