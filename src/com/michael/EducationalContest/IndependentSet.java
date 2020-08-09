package com.michael.EducationalContest;


import com.michael.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class IndependentSet {

    static int n, MOD = (int) 1e9 + 7;
    static ArrayList<Integer>[] g;


    public static int multiply(int a, int b) {

        return (a * b) % MOD;
    }


    /**
     * A dfs on the tree
     *
     * @param a
     * @param p
     * @return a pair with f representing the number of ways the node can be painted black and s the number of ways it can be painted white
     */
    public static Pair<Integer, Integer> solve(int a, int p) {

        int b = 1;
        int w = 0;

        for (int c : g[a]) {
            if (c != p) {
                Pair<Integer, Integer> pair = solve(c, a);

                int mb = b;
                b = multiply(b, pair.s);
                w = multiply(pair.s + pair.f, w) + multiply(mb, pair.f);


            }
        }

        System.out.println(2 * b + w);
        return new Pair<>(b, b + w);
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();

        g = new ArrayList[n];

        for(int i = 0; i < n; i ++){
            g[i] = new ArrayList<>();
        }

        for (int j = 0; j < n - 1; j++) {

            int a = scn.nextInt() - 1;
            int b = scn.nextInt() - 1;

            g[a].add(b);
            g[b].add(a);
        }

        Pair<Integer, Integer> ans = solve(0, -1);

        System.out.println(ans.f + ans.s);


    }

}
