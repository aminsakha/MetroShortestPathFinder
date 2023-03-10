package com.metroshortestpathfinder;

import static com.metroshortestpathfinder.UtilFunctionsKt.findStationNameFromId;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Graph {
    int V = 139;
    Vector<Integer>[] adj;

    static int level;

    Graph() {
        this.adj = new Vector[2 * V];

        for (int i = 0; i < 2 * V; i++)
            this.adj[i] = new Vector<>();
    }

    public void addEdge(int v, int w, int weight) {

        // split all edges of weight 2 into two
        // edges of weight 1 each. The intermediate
        // vertex number is maximum vertex number + 1,
        // that is V.
        if (weight == 2) {
            adj[v].add(v + this.V);
            adj[v + this.V].add(w);
        } else // Weight is 1
            adj[v].add(w); // Add w to v's list.
    }

    public int printShortestPath(Path path, int[] parent, int s, int d) {
        level = 0;
        // If we reached root of shortest path tree
        if (parent[s] == -1) {
            DbKt.getIdListResult().add(s);
            return level;
        }

        printShortestPath(path, parent, parent[s], d);

        level++;
        if (s < this.V) {
            boolean flag = true;
            for (Integer integer : DbKt.getIdListResult()) {
                if (findStationNameFromId(integer).equals(findStationNameFromId(s))) {
                    flag = false;
                    path.setRatio(path.getRatio() + 1);
                    break;
                }
            }
            if (flag)
                DbKt.getIdListResult().add(s);
        }
        return level;
    }

    // finds shortest path from source vertex 's' to
    // destination vertex 'd'.

    // This function mainly does BFS and prints the
    // shortest path from src to dest. It is assumed
    // that weight of every edge is 1
    public int findShortestPath(Path path, int src, int dest) {
        boolean[] visited = new boolean[2 * this.V];
        int[] parent = new int[2 * this.V];

        // Initialize parent[] and visited[]
        for (int i = 0; i < 2 * this.V; i++) {
            visited[i] = false;
            parent[i] = -1;
        }

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {

            // Dequeue a vertex from queue and print it
            int s = queue.peek();

            if (s == dest)
                return printShortestPath(path, parent, s, dest);
            queue.poll();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int i : this.adj[s]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = s;
                }
            }
        }
        return 0;
    }
}
