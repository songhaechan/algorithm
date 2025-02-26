package programers;

import java.util.*;
class Carpet {
    public int[] solution(int brown, int yellow) {
        List<int[]> yellowComb = new ArrayList();

        yellowComb.add(new int[]{yellow,1});

        for(int i=2; i<=Math.sqrt(yellow); i++){
            if(yellow%i == 0){
                yellowComb.add(new int[]{yellow/i,i});
            }
        }

        for(int[] t : yellowComb){
            int border = (t[0]+2)*2 + t[1]*2;
            if(border == brown){
                return new int[]{t[0]+2,t[1]+2};
            }
        }

        return new int[]{0};
    }
}
