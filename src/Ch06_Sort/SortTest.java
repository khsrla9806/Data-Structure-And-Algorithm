package Ch06_Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {
    BubbleSort bubbleSort = new BubbleSort();
    InsertionSort insertionSort = new InsertionSort();
    MergeSort mergeSort = new MergeSort();
    QuickSort quickSort = new QuickSort();

    @Test
    void givenArr_whenRunSortMethod_thenReturnsSortedArr() {
        // Given
        int[] testArr1 = new int[]{8, 4, 6, 7, 5, 3, 2, 1, 10, 9};
        int[] testArr2 = new int[]{8, 4, 6, 7, 5, 3, 2, 1, 10, 9};
        int[] testArr3 = new int[]{8, 4, 6, 7, 5, 3, 2, 1, 10, 9};
        int[] testArr4 = new int[]{8, 4, 6, 7, 5, 3, 2, 1, 10, 9};
        // When
        insertionSort.sort(testArr1);
        bubbleSort.sort(testArr2);
        mergeSort.sort(testArr3);
        quickSort.sort(testArr4);


        // Then
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertArrayEquals(testArr1, sortedArr);
        Assertions.assertArrayEquals(testArr2, sortedArr);
        Assertions.assertArrayEquals(testArr3, sortedArr);
        Assertions.assertArrayEquals(testArr4, sortedArr);
    }
}
