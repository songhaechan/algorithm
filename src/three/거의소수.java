package three;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거의소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int bSquare = (int)Math.ceil(Math.sqrt(b+1));

        List<Long> arr = new ArrayList<>();
        long primeCnt = 0;
        arr.add(1L);
        arr.add(1L);

        int end = (int)Math.ceil(Math.sqrt(b));
        // 임의의 수 n 에대해 √n 은 n보다 작은 모든 수의 두 수의 곱 a*b로 나타낼 때 a와b 둘 중 하나는 적어도 √n보다 작기때문에 vn 까지 탐색
        for (int i = 2; i < bSquare; i++) {
            for (int j = i+i; j <b+1 ; j+=i) {
                // 1은 소수가 아니라는 flag
                arr.add(j,1L);
            }
        }

        // 거의 소수를 담을 배열
        List<Integer> prime = new ArrayList<>();

        long result = 0;

        for (int i = 0; i <b+1 ; i++) {
            if(arr.indexOf(i) != 1){
                prime.add(i);
            }
        }

        for (int i = 0; i < prime.size(); i++) {
            long target = prime.get(i);
            int targetCnt = getLength(target);
            long square = target;
            while((target*=square) <= b){
                if(a<=target){
                    result++;
                }
                int squareCnt = getLength(square);
                if(squareCnt + targetCnt > 15){
                    break;
                }
            }
        }

        bw.write(result+"\n");

        bw.flush();
        bw.close();
    }
    public static int getLength(long tmp) {
        int length = 0;
        while (tmp / 10 != 0) {
            tmp /= 10;
            length++;
        }
        return length;
    }
}
