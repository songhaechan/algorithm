package two;

import java.io.*;
import java.util.*;

public class DFSBFS {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(stringTokenizer.nextToken());

        A = new ArrayList[n + 1];
        visited = new boolean[n+1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i < n+1; i++) {
            Collections.sort(A[i]);
        }
        DFS(start);
        System.out.println();
        for (int i = 1; i < n+1; i++) {
            visited[i] = false;
        }

        Deque<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;
        while(!que.isEmpty()){
            int removed = que.remove();
            System.out.print(removed+" ");
            for(int i : A[removed]){
                if(!visited[i]){
                    visited[i] = true;
                    que.add(i);
                }
            }
        }

    }

    private static void DFS(int start) {
        if(visited[start]){
            return;
        }
        visited[start] = true;
        System.out.print(start+" ");
        for (int i : A[start]) {
            DFS(i);
        }
    }

}
