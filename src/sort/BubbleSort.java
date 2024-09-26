package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        // 시간 복잡도 Worst Case 빅세타(n^2) Best case 빅세타(n)
        // Best case 경우 모든 원소가 정렬된 case
        // https://s-y-130.tistory.com/148 참고
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
