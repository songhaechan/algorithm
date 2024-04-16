    package four;

    import java.io.*;
    import java.util.StringTokenizer;

    public class p1389 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            // 친구의 수
            int n = Integer.parseInt(st.nextToken());
            // 관계의 수
            int m = Integer.parseInt(st.nextToken());

            int[][] distance = new int[n+1][n+1];

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(i == j){
                        distance[i][j] = 0;
                    }else{
                        distance[i][j] = 10000001;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                distance[a][b] = 1;
                distance[b][a] = 1;
            }

            for (int k = 1; k < n + 1; k++) {
                for (int i = 1; i < n + 1; i++) {
                    for (int j = 1; j < n + 1; j++) {
                        if(distance[i][j] > distance[i][k] + distance[k][j])
                            distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }

            int max = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 1; i < n + 1; i++) {
                int sum = 0;
                for (int j = 1; j < n + 1; j++) {
                    sum += distance[i][j] ;
                }
                if(max > sum){
                    max = sum;
                    result = i;
                }
            }

            sb.append(result+"\n");

            bw.write(String.valueOf(sb));
            bw.flush();
            bw.close();
        }
    }
