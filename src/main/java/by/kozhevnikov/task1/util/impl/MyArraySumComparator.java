package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;
import by.kozhevnikov.task1.service.impl.ArraySumServiceImpl;

import java.util.Comparator;

public class MyArraySumComparator implements Comparator<MyArray> {

  @Override
  public int compare(MyArray a, MyArray b) {

    ArraySumServiceImpl sumService = new ArraySumServiceImpl();

    return Integer.compare(sumService.calculate(a), sumService.calculate(b));
  }
}
