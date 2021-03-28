// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath {

    //Trouve la distance minimum entre le noeud actuel et les noeuds connexes qui n'ont pas été visité
    static final int NB_NOEUD = 8;
    int minDistance(int[] dist, Boolean[] cheminMin)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < NB_NOEUD; v++)
            if (!cheminMin[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        System.out.println("min distance" + min_index);
        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int[] dist)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < NB_NOEUD; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int[][] graph, int dep, int arv)
    {
        int[] dist = new int[NB_NOEUD]; // The output array. dist[i] will hold
        // the shortest distance from dep to i

        //Création du tableau pour pouvoir track le chemin
        int[] parents = new int[NB_NOEUD];

        //Le premier noeuds n'a aucun parent
        parents[dep] = -1;

        // cheminMin[i] will true if vertex i is included in shortest
        // path tree or shortest distance from dep to i is finalized
        Boolean[] cheminMin = new Boolean[NB_NOEUD];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < NB_NOEUD; i++) {
            dist[i] = Integer.MAX_VALUE;
            cheminMin[i] = false;
        }

        // La distance du point de depart sera toujours zero
        dist[dep] = 0;

        // trouve le plus court chemin pour chaque noeuds
        for (int count = 0; count < NB_NOEUD - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to dep in first
            // iteration.
            int u = minDistance(dist, cheminMin);
            //System.out.println("u" + u);

            // Mark the picked vertex as processed
            cheminMin[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < NB_NOEUD; v++)

                // Update dist[v] only if is not in cheminMin, there is an
                // edge from u to v, and total weight of path from dep to
                // v through u is smaller than current value of dist[v]
                if (!cheminMin[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    System.out.println(dist[u] +" " + graph[u][v]);}
        }

        // print the constructed distance array
        //printSolution(dist);
        System.out.println(Arrays.toString(cheminMin));
    }

    // Driver method
    public static void main(String[] args)
    {
        /* Matrice de la map les noeuds sont bi-directionel */
        int[][] graph = new int[][] { { 0, 5, 0, 0, 0, 1, 2, 0},
                { 5, 0, 1, 0, 0, 0, 3, 0},
                { 0, 1, 0, 6, 0, 0, 0, 3},
                { 0, 0, 6, 0, 12, 0, 0, 6},
                { 0, 0, 0, 12, 0, 3, 0, 4},
                { 1, 0, 0, 0, 3, 0, 1, 0},
                { 2, 3, 0, 0, 0, 1, 0, 10},
                { 0, 0, 3, 6, 4, 0, 10, 0}};
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0, 0);
    }
}
// This code is contributed by Aakash Hasija

