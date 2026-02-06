package by.kozhevnikov.task1.service;

import by.kozhevnikov.task1.entity.CustomArray;

public interface SortService {

  int[] quickSort(CustomArray array);

  int[] insertSort(CustomArray array);

}