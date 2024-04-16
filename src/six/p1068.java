package six;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1068 {
    static ArrayList<Integer>[] list;
    static int deleteNode;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }


        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node != -1){
                list[node].add(i);
                list[i].add(node);
            }else root = i;
        }

        st = new StringTokenizer(br.readLine());
        deleteNode = Integer.parseInt(st.nextToken());

        // 루트 노드가 0이 아닐 수 있나?
        if(deleteNode == 0){
            System.out.println(0);
        }else {
            dfs(0);
            System.out.println(result);
        }

//        if(deleteNode == root){
//            System.out.println(0);
//        }else{
//            dfs(root);
//            System.out.println(result);
//        }
    }

    static void dfs(int s) {
        visited[s] = true;
        int cNode = 0;
        for (int elem : list[s]) {
            if(!visited[elem] && elem != deleteNode){
                cNode++;
                dfs(elem);
            }
        }
        if(cNode == 0){
            result++;
        }
    }
}
