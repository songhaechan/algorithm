package bj220;

import java.io.*;

public class p10172 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("|" + "\\" + "_" + "/" + "|" + "\n");
        sb.append("|"+"q"+" "+"p"+"|"+"   "+"/}"+"\n");
        sb.append("("+" 0 "+")"+"\""+"\""+"\""+"\\"+"\n");
        sb.append("|\"^\"`    |"+"\n");
        sb.append("||_/=\\\\__|");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
