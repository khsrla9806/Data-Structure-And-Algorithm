package Ch06_Sort;

public class MergeSort {
    public void sort(int[] arr) {
        // 인플레이스 정렬
        mergeSort(arr, 0, arr.length - 1); // 가장 처음 배열의 첫 번째 인덱스와 마지막 인덱스를 넣어서 분할을 시작
    }

    // 분할하는 과정
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + ((high - low) / 2);

        mergeSort(arr, low, mid); // 왼쪽으로 쪼개지고
        mergeSort(arr, mid + 1, high); // 오른쪽으로 쪼개지고

        merge(arr, low, mid, high); // 왼쪽, 오른쪽으로 쪼갰던 것을 합병
    }

    // 합병하는 과정
    private void merge(int[] arr, int low, int mid, int high) {
        // 임시 배열을 두고 사용
        int[] temp = new int[high - low + 1];
        int idx = 0; // 정렬된 값을 하나씩 temp에 넣어갈 인덱스

        // 왼쪽에 쪼개진 배열의 인덱스
        int left = low;
        // 오른쪽에 쪼개진 배열의 인덱스
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        // 왼쪽, 오른쪽 배열에 아직 남아있는 값이 존재할 수 있다.
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        while (right <= high) {
            temp[idx++] = arr[right++];
        }

        // 원본 배열에 값을 갱신해줘야 한다.
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
