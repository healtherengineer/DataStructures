
import java.util.LinkedList;

public class BloodGraph {

    private int V;
    private LinkedList<Kan> adj[]; //Adjacency Lists

    BloodGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, Kan w) {
        adj[v].add(w);
    }

    public void printGraph() {
        for (int i = 0; i < this.V; i++) {
            if (!adj[i].isEmpty()) {
                System.out.println(adj[i]);
            }
        }
    }

}
