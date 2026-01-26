package by.kozhevnikov.task1.service;

import by.kozhevnikov.task1.entity.MyArray;

public interface SortService {

  int[] quickSort(MyArray array);

  int[] insertSort(MyArray array);

}