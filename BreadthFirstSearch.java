import java.util.*;

public class BreadthFirstSearch {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {
        graph.put("a1", Arrays.asList("a2", "a3"));
        graph.put("a2", Arrays.asList("a3", "a4"));
        graph.put("a3", Arrays.asList("a4", "a5"));
        graph.put("a4", Arrays.asList("a5", "a6"));
        graph.put("a5", Arrays.asList("a6"));
        graph.put("a6", Arrays.asList("a7"));
        graph.put("a7", Collections.emptyList());

        String target = "a7";
        System.out.println("Proses pencarian BFS");
        bfs("a1", target);
    }

    public static void bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Mengunjungi " + node);

            if (node.equals(target)) {
                System.out.println("Node " + target + " ditemukan!");
                return;
            }

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}