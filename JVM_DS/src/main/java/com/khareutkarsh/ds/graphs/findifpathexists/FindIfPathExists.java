package com.khareutkarsh.ds.graphs.findifpathexists;

import java.util.*;

/**
 * Leet code problem # 1971
 */
public class FindIfPathExists {
    public static void main(String[] args) {
        FindIfPathExists obj = new FindIfPathExists();
        int n = 3;
        int [][] edges = {{0,1},{1,2},{2,0}};
        int src = 0;
        int dest = 2;
        System.out.println(obj.findIfValidPathExists(n, edges, src, dest));
    }
    public boolean findIfValidPathExists(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited,false);
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i =0;i<edges.length;i++)
        {
            addEdge(adjList,edges[i][0],edges[i][1]);
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                if(bfs(adjList,visited,source,destination))
                    return true;
            }
        }


        return false;
    }

    void addEdge(List<List<Integer>> adjList,int a,int b)
    {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    boolean bfs(List<List<Integer>> adjList,boolean visited[],int source, int destination)
    {
        Queue<Integer> bfsQ = new LinkedList<Integer>();
        bfsQ.offer(source);
        visited[source]=true;
        while(!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();
            for(int i=0;i<adjList.get(cur).size();i++)
            {
                int neighbour = adjList.get(cur).get(i);
                if(visited[neighbour] == false)
                {
                    visited[neighbour]=true;
                    bfsQ.add(neighbour);
                }
                if(neighbour==destination)
                {
                    return true;
                }
            }
        }
        if(visited[destination])
            return true;
        return false;
    }
}
