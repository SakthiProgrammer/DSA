package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public Graph(int vertex) {
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printAdjList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        int len = adjList.size();
        boolean[] visited = new boolean[len];
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            System.out.print(" " + vertex);
            for (int i = 0; i < adjList.get(vertex).size(); i++) {

                int currVertex = adjList.get(vertex).get(i);
                if (!visited[currVertex]) {
                    queue.offer(currVertex);
                    visited[currVertex] = true;
                }
            }
        }

    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        dfs(startVertex, visited);
    }

    // Recursive DFS helper function
    private void dfs(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int neighbor : adjList.get(currentVertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
