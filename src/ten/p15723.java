package ten;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15723 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char start = st.nextToken().charAt(0);
            st.nextToken();
            char end = st.nextToken().charAt(0);
            list[start-97].add((int) end);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            visited = new boolean[26];
            st = new StringTokenizer(br.readLine());
            char start = st.nextToken().charAt(0);
            st.nextToken();
            char target = st.nextToken().charAt(0);
            dfs(start, target);
            if(flag){
                sb.append("T").append("\n");
            }else{
                sb.append("F").append("\n");
            }
            flag=false;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void dfs(int start, int target){
        visited[start-97] = true;
        if(start == target){
            flag=true;
        }

        for(int next : list[start-97]){
            if(!visited[next-97]){
                dfs(next,target);
            }
        }
    }
}
