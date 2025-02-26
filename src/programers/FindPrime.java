package programers;

import java.util.*;
class FindPrime {
    static Set<Integer> set = new HashSet();
    static boolean[] visited = new boolean[7];
    public int solution(String numbers) {

        dfs(numbers,"",0);

        int count = 0;
        for(Integer n : set){
            System.out.println(n);
            if(isPrimeNumber(n)){
                count++;
            }
        }
        return count;
    }

    static public void dfs(String numbers, String target, int depth){
        if(depth > numbers.length()){
            return;
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] =true;
                set.add(Integer.parseInt(target+numbers.charAt(i)));
                dfs(numbers,target+numbers.charAt(i),depth+1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrimeNumber(int n){
        if(n==0 || n==1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i ==0) return false;
        }
        return true;
    }
}
