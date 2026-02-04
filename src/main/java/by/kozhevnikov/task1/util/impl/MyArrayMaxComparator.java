package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;
import by.kozhevnikov.task1.warehouse.Warehouse;

import java.util.Comparator;

public class MyArrayMaxComparator implements Comparator<MyArray> {
  @Override
  public int compare(MyArray a, MyArray b) {

    ArrayMinMaxServiceImpl maxService = new ArrayMinMaxServiceImpl();

    return Integer.compare(maxService.max(a), maxService.max(b));

  }
}
