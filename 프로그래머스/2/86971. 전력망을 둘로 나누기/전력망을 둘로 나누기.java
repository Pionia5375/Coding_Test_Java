class Solution {
    public int solution(int n, int[][] wires) {
        int minDifference = Integer.MAX_VALUE;

        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];
            graph[u][v] = true; 
            graph[v][u] = true;
        }

        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            graph[u][v] = false;
            graph[v][u] = false;

            boolean[] visited = new boolean[n + 1];
            int count = dfs(u, graph, visited, n);

            int diff = Math.abs(count - (n - count));
            minDifference = Math.min(minDifference, diff);

            graph[u][v] = true;
            graph[v][u] = true;
        }

        return minDifference;
    }

    private int dfs(int node, boolean[][] graph, boolean[] visited, int n) {
        visited[node] = true;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (graph[node][i] && !visited[i]) {
                count += dfs(i, graph, visited, n);
            }
        }

        return count;
    }
}