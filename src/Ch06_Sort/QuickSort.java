package Ch06_Sort;

public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = low + ((high - low) / 2);
        int pivotValue = arr[pivot];

        int left = low;
        int right = high;

        while (left <= right) {
            // Pivot 왼쪽에 있는 값이 pivot 값 보다 큰 값이 나올 때까지 인덱스 증가
            // 같아도 멈추기 때문에 pivot 값을 넘어가지 않는다.
            while (arr[left] < pivotValue) {
                left++;
            }

            // Pivot 오른쪽에 있는 값이 pivot 값 보다 작은 값이 나올 때까지 인덱스 증가
            while (arr[right] > pivotValue) {
                right--;
            }

            // 만약 left와 right가 교차해서 지나가지 않았다면, 두 값을 바꿔줍니다.
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, low, right);
        quickSort(arr, left, high);
    }
}
