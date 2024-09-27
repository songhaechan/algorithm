package sort;

/**
 * 시간 복잡도 : 빅세타(n^2)
 * 정렬된 경우 빅세타(n)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,13,24,1,6,23,52,12};

        for (int i = 1; i < arr.length; i++) {
            int idx = i - 1; // 정렬된 요소의 맨 마지막
            int newItem = arr[i];
            while (idx >= 0 && newItem < arr[idx]) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = newItem;
        }

        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
