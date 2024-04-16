package seven;

import java.io.*;
import java.util.StringTokenizer;

public class p11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());

        long result = n;

        for(long p = 2; p<= Math.sqrt(n);p++){
            // 반복문은 소수인 2부터 시작하고 밑의 while문에서 배수들은 다 제거하기때문에 n%p==0이면 소수임이 보장됨
            if(n%p == 0){
                // p가 소수일때 n이 p로 나누어떨어지면 n은 p를 약수로 가지고 있다는 뜻이고 p의 배수는 p를 약수로 가지기 때문에
                // n과 서로소일 수 없다.
                result = result - result/p;
                // 이 while문에서 p의 배수들을 다 제거
                while(n%p == 0){
                    n /= p;
                }
            }
        }
        if(n>1){
            result = result - result/n;
        }

        System.out.println(result);

    }
}
