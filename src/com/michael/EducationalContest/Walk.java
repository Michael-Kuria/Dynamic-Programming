package com.michael.EducationalContest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Walk {

    public static class Vertex{

        int color = 0;
        long depth = 0;
        List<Vertex> adj = new ArrayList<>();
    }

    static Vertex [] g;
    static int n, cnt = 0, MOD = (int)(1e7 + 9);
    static long k;

    public static void solve(Vertex v){

        if(v.depth == k){
            cnt ++;
            cnt %= MOD;
            return;
        }

        for(Vertex u: v.adj){

            u.depth = v.depth + 1;
            solve(u);


        }


    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        k = scan.nextLong();

        g = new Vertex[n];

        for(int i = 0; i < n; i ++){
            g[i] = new Vertex();
        }

        for(int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                int x = scan.nextInt();

                if(x == 1){
                    g[i].adj.add(g[j]);
                }
            }
        }

        for(int i = 0; i < n; i ++){

            g[i].depth = 0;

            solve(g[i]);
        }

        System.out.println(cnt);
    }
}
