package four;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class p1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(operator == 0){
                union(a,b);
            }
            if(operator == 1){
                int x = findParent(a);
                int y = findParent(b);
                if(x != y){
                    sb.append("NO").append("\n");
                }else{
                    sb.append("YES").append("\n");
                }
            }
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a!=b){
            if(a<b){
                // 이제부터 b의 부모는 a
                parent[b] = a;
            }else{
                parent[a] = b;
            }
        }
    }

    static int findParent(int x){
        if(x == parent[x]){
            return x;
        }

        // 부모 갱신
        return parent[x] = findParent(parent[x]);
    }
}
