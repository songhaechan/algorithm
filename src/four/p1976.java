package four;

import java.io.*;
import java.util.StringTokenizer;

public class p1976 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        // 도시
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 여행 계획에 속한 도시
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        // 루트 노드 초기화
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        int[][] connect = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <n+1 ; j++) {
                int connectedNode = Integer.parseInt(st.nextToken());
                if(connectedNode == 1){
                    union(i,j);
                }
            }
        }

        int[] route = new int[m];

        st = new StringTokenizer(br.readLine());
        int result = find(Integer.parseInt(st.nextToken()));
        boolean flag = true;
        for (int i = 0; i < m-1; i++) {
            if(result != find(Integer.parseInt(st.nextToken()))){
                sb.append("NO").append("\n");
                flag = false;
                break;
            }
        }
        if(flag){
            sb.append("YES").append("\n");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
    static void union(int v1, int v2){
        int a = find(v1);
        int b = find(v2);

        if(a!=b) {
            parent[b] = a;
        }
    }

    static int find(int target){
        if(target == parent[target]){
            return target;
        }

        return parent[target] = find(parent[target]);
    }
}
