package Ch06_Sort;

public class BubbleSort {
    public void sort(int[] arr) {
        // 안정 정렬 : 중복된 값의 순서가 보장이 됨.
        // 인플레이스 정렬 : 내부 arr에서 정렬이 진행된다.
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
