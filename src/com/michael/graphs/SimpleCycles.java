package com.michael.graphs;

/**
 * Given an undirected simple graph find the number of simple cycles.
 *
 * A Simple graph: No more than one edge connects any pair of vertices
 * A Simple cycle is a cycle where each vertex appears at most once.
 */
public class SimpleCycles {

    static int n, m; // number of vertices and the number of edges
    static boolean g[][];

    public static void solve(){

        int [][] dp = new int[1 << n][n];

        int [] cycle = new int[n + 1];

        for(int mask = 0; mask < (1 << n); mask ++){

            int cnt = Integer.bitCount(mask);

            int f = 0; // the first vertex in the cycle
            for(; f < n; f ++){
                if((mask & (1 << f)) != 0) break;
            }

            if(cnt == 1){
                dp[mask][f] = 1;
            }else if(cnt > 1){

                for(int last = f + 1; last < n; last ++){

                    if((mask & (1 << last)) != 0){

                        for(int x = f ; x < n; x ++){

                            if( x != last && (mask & (1 << x)) != 0 && g[last][x]){

                                dp[mask][last] += dp[mask ^ (1 << last)][x];
                            }
                        }
                    }

                    if(g[last][f]){
                        cycle[cnt] += dp[mask][last];
                    }

                }
            }
        }


        int ans = 0;
        for(int cnt = 3; cnt <= n; cnt ++)
            ans += cycle[cnt];

        System.out.println(ans/2);// since cycles will be calculated twice


    }

    public static void main(String [] args){
        n = 4; m = 6;

        g = new boolean[n][n];

        int edges [][] = {{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};

        for(int i = 0; i < m; i ++){
            int a = edges[i][0] - 1 , b = edges[i][1] - 1;
            g[a][b] = g[b][a] = true;
        }

        solve();
    }


}
