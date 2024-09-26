package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        // 시간복잡도 빅세타(n^2) : i 이후로 가장 작은 혹은 가장 큰 수의 인덱스를 찾는다. 그 후 스왑
        for(int i=0; i<arr.length; i++){
            int tmp = i;
            for (int j = i+1; j <arr.length; j++) {
                if(arr[j]<arr[tmp]){
                    tmp = j;
                }
            }
            int c = arr[tmp];
            arr[tmp] = arr[i];
            arr[i] = c;
        }

        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
