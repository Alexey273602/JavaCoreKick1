package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;

import java.util.Comparator;

public class MyArrayMinComparator implements Comparator<MyArray> {

  @Override
  public int compare(MyArray a, MyArray b) {
    ArrayMinMaxServiceImpl minService = new ArrayMinMaxServiceImpl();

    return Integer.compare(minService.min(a), minService.min(b));
  }
}
