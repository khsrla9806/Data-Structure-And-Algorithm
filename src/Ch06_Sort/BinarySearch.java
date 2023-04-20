package Ch06_Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        // step 1. 데이터의 중간 인덱스 찾기
        // step 2. 중간 인덱스 위치를 기준으로 arr 을 절반으로 나누기
        // step 3. 나눠진 절반의 리스트에서 목표하는 값을 찾기

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = left + ((right - left) / 2); // OverFlow Exception을 발지하기 위함

            // 원하는 값을 찾았으면 해당 값의 인덱스를 리턴한다.
            if (arr[mid] == target) {
                return mid;
            }

            // 타겟이 중간보다 크면 오른쪽 배열만 확인
            // 중간보다 작으면 왼쪽 배열만 확인
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 찾는 값이 없으면 -1을 리턴
        return -1;
    }

    @DisplayName("")
    @Test
    void givenRandomArr_whenRe() {
        Random random = new Random();
        // 100번 랜덤한 값을 갖는 배열을 만들어서 테스트 진행
        for (int i = 0; i < 100; i++) {
            int[] testArr = createRandomArr(100);
            int answerIdx = random.nextInt(testArr.length);
            int target = testArr[answerIdx];

            Assertions.assertEquals(search(testArr, target), answerIdx);
        }
    }

    public static int[] createRandomArr(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt();
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 4, 6, 8, 12, 17, 19, 25, 38, 39, 45, 48, 52, 55}, 12));
    }
}
