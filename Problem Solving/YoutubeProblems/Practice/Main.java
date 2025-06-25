import Graph.Graph;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Graph gp = new Graph(5);
        gp.addEdge(0, 1);
        gp.addEdge(0, 4);
        gp.addEdge(4, 3);
        gp.addEdge(4, 1);
        gp.addEdge(1, 2);
        gp.addEdge(3, 2);

        gp.printAdjList();

        gp.bfs(0);

        System.out.println("\ndfs");
        gp.dfs(0);

    }
}