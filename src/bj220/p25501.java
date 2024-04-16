package bj220;

import java.io.*;
import java.util.StringTokenizer;

public class p25501 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        String[] alpha;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            alpha = new String[word.length()];
            for (int j = 0; j < word.length(); j++) {
                alpha[j] = word.substring(j,j+1);
            }
            int palindrome = isPalindrome(alpha);
            sb.append(palindrome+" ");
            sb.append(count+"\n");
            count = 0;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int recursive(String[] alpha,int l,int r){
        count++;
        if(l>=r){
            return 1;
        }else if(!alpha[l].equals(alpha[r])){
            return 0;
        }else{
            return recursive(alpha,l+1,r-1);
        }
    }
    static int isPalindrome(String[] alpha){
        return recursive(alpha,0,alpha.length-1);
    }
}
