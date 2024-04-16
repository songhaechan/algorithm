package five;

import java.io.*;
import java.util.*;

public class p9252 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String tmp1 = scan.nextLine();
        char[] str1 = tmp1.toCharArray();
        String tmp2 = scan.nextLine();
        char[] str2 = tmp2.toCharArray();

        int str1Length = tmp1.length();
        int str2Length = tmp2.length();
        int[][] lsc = new int[str1Length+1][str2Length+1];

        for (int i = 0; i < str1Length; i++) {
            lsc[i][0] = 0;
        }
        for (int i = 0; i < str2Length; i++) {
            lsc[0][i] = 0;
        }

        List<Character> result = new ArrayList<>();

        for (int i = 1; i <str1Length+1 ; i++) {
            for (int j = 1; j <str2Length+1 ; j++) {
                if(str1[i-1] == str2[j-1]){
                    lsc[i][j] = lsc[i-1][j-1] + 1;
                }else{
                    lsc[i][j] = Math.max(lsc[i][j-1],lsc[i-1][j]);
                }
            }
        }

        int i = str1Length;
        int j = str2Length;
        while(i>0 && j>0){
            if(lsc[i][j] == lsc[i-1][j]){
                i--;
                continue;
            }
            if(lsc[i][j] == lsc[i][j-1]){
                j--;
                continue;
            }
            i--; j--;
            result.add(str1[i]);
        }


        if(result.size() == 0){
            System.out.println(0);
        }else{
            System.out.println(result.size());
            for (int k = result.size()-1; k >=0 ; k--) {
                System.out.print(result.get(k));
            }
        }

    }
}
