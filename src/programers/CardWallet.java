package programers;

import java.util.*;
class CardWallet {
    public int solution(int[][] sizes) {
        Integer[] width = new Integer[sizes.length];
        Integer[] hight = new Integer[sizes.length];

        int maxWidth = 0;
        int maxHight = 0;

        for(int i=0; i<sizes.length; i++){
            width[i] = sizes[i][0];
            if(maxWidth < width[i]){
                maxWidth = width[i];
            }
            hight[i] = sizes[i][1];
            if(maxHight < hight[i]){
                maxHight = hight[i];
            }
        }

        if(maxWidth > maxHight){
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][1] > sizes[i][0]){
                    hight[i] = width[i];
                }
            }
            Arrays.sort(hight,Collections.reverseOrder());
            return maxWidth * hight[0];
        }else{
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][0] > sizes[i][1]){
                    width[i] = hight[i];
                }
            }
            Arrays.sort(width,Collections.reverseOrder());
            return maxHight * width[0];
        }
    }
}