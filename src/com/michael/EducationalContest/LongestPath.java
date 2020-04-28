package com.michael.EducationalContest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Finding the Longest path in a directed Graph
 *
 * We will represent the graph using a adjacency Lists
 */
public class LongestPath {

    /**
     * A class to hold all the information about a vertex
     */
    public static class Vertex{

        ArrayList<Integer> edges = new ArrayList<>(); // will consist of all the edges originating from this

        int in = 0; // keep count of all the incoming edges

        boolean visited = false; // am i visited

        int d = 0; // Longest distance
    }

    /**
     * Depth First search algo
     * @param a
     * @param v
     */
    public static void dfs(int a, Vertex [] v){
        assert !v[a].visited;

        v[a].visited = true;

        // traverse over all the outgoing edges

        for(int b : v[a].edges){
            v[b].d = Math.max(v[b].d , v[a].d + 1);
            v[b].in --;

            if(v[b].in == 0 && !v[b].visited){
                dfs(b,v);
            }
        }


    }

    public static int longestPath(Vertex [] v){

        for(int i = 0; i < v.length; i ++){
            if(!v[i].visited && v[i].in == 0) // start at a vertex with 0 in edges
                dfs(i,v);
        }

        int ans = 0;

        for(int i = 0; i < v.length; i ++){
            ans = Math.max(ans, v[i].d);
            //System.out.println("d "+i +" " + v[i].d);
        }


        return ans;

    }


    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n, m;

        n = scan.nextInt();
        m = scan.nextInt();

        Vertex [] v = new Vertex[n];

        for(int i = 0; i < n; i ++){
            v[i] = new Vertex();
        }


        for(int i = 0; i < m; i ++){

            int a  = scan.nextInt();
            int b = scan.nextInt();
            v[a - 1].edges.add(b - 1);
            v[b - 1].in ++;

        }



        System.out.println("Longest path : " + longestPath(v));



    }


}
