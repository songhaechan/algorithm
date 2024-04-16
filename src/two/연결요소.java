package two;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        A = new ArrayList[n+1];
        visited=new boolean[n+1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        bufferedWriter.write(count+"\n");

        bufferedWriter.flush();
        bufferedWriter.close();
    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;

        for(int i: A[v]){
            if (visited[i] == false){
                DFS(i);
            }
        }
    }
}
