package ele;

import java.io.*;
import java.util.*;

public class p12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 물품의 종류
        int N = Integer.parseInt(st.nextToken());
        // 배낭 무게
        int K = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Node(weight,value));
        }
        Collections.sort(list);
        int[][] dp = new int[N+1][K+1];

        for (int i = 0; i < K + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        // 물건
        for (int i = 1; i < N + 1; i++) {
            // 최대 무게
            for (int j = 1; j < K + 1; j++) {
                if(j>=list.get(i-1).weight){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-list.get(i-1).weight]+list.get(i-1).value);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
    static class Node implements Comparable<Node> {
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
