package com.michael.EducationalContest;

import java.util.*;

public class IndependentSet {
    public static class Node{
        Node p;
        List<Node> adj = new ArrayList<>();
        int color;

    }

    static Node [] tree;
    static int n, cnt = 0;



    public static void solve(Node n, int x){

        Queue<Node> q = new ArrayDeque<>();
        n.color = x;
        q.offer(n);

        while(!q.isEmpty()){
            Node u = q.poll();

            for(Node node: u.adj){

                q.offer(node);
                if (u.color != 1) {
                    solve(node, 1);
                }
                solve(node,0);
            }
        }

        cnt ++;
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        tree = new Node[n];

        for(int i = 0; i < n; i ++)
            tree[i] = new Node();

        for(int i = 0; i < n - 1; i ++){

            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;

            tree[a].adj.add(tree[b]);
            tree[b].p = tree[a];
        }

        for(int i = 0; i < n; i ++){
            if(tree[i].p == null){
                solve(tree[i],0);
                solve(tree[i],1);
            }
        }

        System.out.println(cnt);
    }


}
