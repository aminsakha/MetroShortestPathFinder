package com.metroshortestpathfinder

import android.util.Log
import java.util.*

fun addEdge(i: Int, j: Int) {
    adj[i].add(j)
    adj[j].add(i)
}

fun printShortestDistance(
    adj: ArrayList<ArrayList<Int>>,
    s: Int, dest: Int
) {
    // predecessor[i] array stores predecessor of
    // i and distance array stores distance of i
    // from s
    val pred = IntArray(stationList.size)
    val dist = IntArray(stationList.size)
    if (!bfs(adj, s, dest, stationList.size, pred, dist)) {
        println(
            "Given source and destination" +
                    "are not connected"
        )
        return
    }

    // LinkedList to store path
    val path = LinkedList<Int>()
    var crawl = dest
    path.add(crawl)
    while (pred[crawl] != -1) {
        path.add(pred[crawl])
        crawl = pred[crawl]
    }

    // Print distance
    println("Shortest path length is: " + dist[dest])

    // Print path
    println("Path is ::")
    for (i in path.indices.reversed()) {
        Log.d("stations", findStationFromId(path[i])?.name + " ")
    }
}

private fun bfs(
    adj: ArrayList<ArrayList<Int>>, src: Int,
    dest: Int, v: Int, pred: IntArray, dist: IntArray
): Boolean {
    // a queue to maintain queue of vertices whose
    // adjacency list is to be scanned as per normal
    // BFS algorithm using LinkedList of Integer type
    val queue = LinkedList<Int>()

    // boolean array visited[] which stores the
    // information whether ith vertex is reached
    // at least once in the Breadth first search
    val visited = BooleanArray(v)

    // initially all vertices are unvisited
    // so v[i] for all I is false
    // and as no path is yet constructed
    // dist[i] for all I set to infinity
    for (i in 0 until v) {
        visited[i] = false
        dist[i] = Int.MAX_VALUE
        pred[i] = -1
    }

    // now source is first to be visited and
    // distance from source to itself should be 0
    visited[src] = true
    dist[src] = 0
    queue.add(src)

    // com.metroshortestpathfinder.bfs Algorithm
    while (!queue.isEmpty()) {
        val u = queue.remove()
        for (i in adj[u].indices) {
            if (!visited[adj[u][i]]) {
                visited[adj[u][i]] = true
                dist[adj[u][i]] = dist[u] + 1
                pred[adj[u][i]] = u
                queue.add(adj[u][i])

                // stopping condition (when we find
                // our destination)
                if (adj[u][i] == dest) return true
            }
        }
    }
    return false
}