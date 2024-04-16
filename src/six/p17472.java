package six;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17472 {
    static int[] parent;
    static int n,m;
    static boolean[][] visited;
    static PriorityQueue<Node> pq;
    static int[][] map;
    static int flag = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                if(map[i][j]==1 && !visited[i][j]){
                    bfs(i,j);
                    flag++;
                }
            }
        }

        pq = new PriorityQueue<>();

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if(map[i][j]!=0){
                    // map[i][j]는 섬의 번호
                    makeBridge(i,j,map[i][j]);
                }
            }
        }

        parent = new int[flag];
        for (int i = 1; i <flag ; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int result = 0;

        while(!pq.isEmpty()){
            Node elem = pq.poll();
            if(find(elem.s) != find(elem.e)){
                union(elem.s,elem.e);
                result += elem.w;
                cnt++;
            }
        }

        if(cnt>=flag-2){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }

    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x!=y){
            parent[x] = y;
        }
    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    static void makeBridge(int x, int y, int sum){
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            q.offer(new int[] {x,y,0});
            visited[x][y] = true;
            while(!q.isEmpty()){
                int[] point = q.poll();
                int px = point[0] + dx[i];
                int py = point[1] + dy[i];
                int move = point[2];
                if(px<0 || py <0 || px > n-1 || py > m-1 || visited[px][py]) continue;

                // 현재 섬과 다른 섬
                if(map[px][py]!=sum){
                    // 만났다면
                    if(map[px][py]!=0){
                        int from = sum;
                        int to = map[px][py];
                        int length = move;
                        // 다리 길이는 2이상이다
                        if(length>1){
                            pq.offer(new Node(from,to,length));
                            break;
                        }
                    }else{
                        visited[px][py] = true;
                        q.offer(new int[]{px,py,move+1});
                    }
                }
            }
            q.clear();
        }
    }
    static void bfs(int x, int y){
        // bfs용 큐
        Queue<int[]> q = new LinkedList<>();
        // 섬을 만나면 큐에 섬 좌표 저장
        q.add(new int[] {x,y});
        // 섬의 번호 저장
        map[x][y] = flag;
        // 방문 체크
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] point = q.poll();
            int px = point[0];
            int py = point[1];
            // 4가지 방향에대해 수행
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || visited[nx][ny]) continue;
                if(map[nx][ny] == 1){
                    map[nx][ny] = flag;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
