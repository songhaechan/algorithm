package nine;

import java.io.*;
import java.util.*;

public class p13549{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist,-1);
        dist[n] = 0;
        que.offer(n);

        if(n==k){
            System.out.println(0);
        }else{
            while(!que.isEmpty()){
                Integer now = que.poll();
                if(now-1>=0 && dist[now-1] == -1){
                    que.offer(now-1);
                    dist[now-1] = dist[now]+1;
                }
                if(now+1<=100000 && dist[now+1] ==-1 ){
                    que.offer(now+1);
                    dist[now+1] = dist[now]+1;
                }
                if(now*2<=100000 && dist[now*2] == -1){
                    que.offerFirst(now*2);
                    dist[now*2] = dist[now];
                }
            }
            System.out.println(dist[k]);
        }

    }
}
