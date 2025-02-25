package programers;
import java.util.*;

class Clothes {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap();

        for(String[] clothe : clothes){
            map.put(clothe[1],map.getOrDefault(clothe[1],0)+1);
        }

        return map.values().stream().reduce(1,(total,c)-> total * (c+1)) -1;

    }
}