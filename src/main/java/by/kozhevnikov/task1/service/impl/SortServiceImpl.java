package by.kozhevnikov.task1.service.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.service.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortServiceImpl implements SortService {

  private static final Logger logger =
          LoggerFactory.getLogger(SortServiceImpl.class);

  @Override
  public int[] quickSort(MyArray array) {
    int[] data = array.get();
    logger.info("Начало быстрой сортировки массива, длина={}", data.length);

    quickSortRecursive(data, 0, data.length - 1);

    logger.info("Быстрая сортировка завершена: {}", java.util.Arrays.toString(data));
    return data;
  }

  private void quickSortRecursive(int[] arr, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(arr, low, high);
      quickSortRecursive(arr, low, pivotIndex - 1);
      quickSortRecursive(arr, pivotIndex + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private void swap(int[] arr, int i, int j) {
    if (i != j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  @Override
  public int[] insertSort(MyArray array) {
    int[] data = array.get();
    logger.info("Начало сортировки вставками массива, длина={}", data.length);

    for (int i = 1; i < data.length; i++) {
      int key = data[i];
      int j = i - 1;

      while (j >= 0 && data[j] > key) {
        data[j + 1] = data[j];
        j--;
      }

      data[j + 1] = key;
    }

    logger.info("Сортировка вставками завершена: {}", java.util.Arrays.toString(data));
    return data;
  }
}
