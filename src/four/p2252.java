package four;

import java.io.*;
import java.util.*;

public class p2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.valueOf(st.nextToken()));
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                inDegree[list[i].get(j)]++;
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            Integer elem = q.poll();
            sb.append(elem + " ");
            for(int target : list[elem]){
                inDegree[target]--;
                if(inDegree[target] == 0){
                    q.offer(target);
                }
            }
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}
