package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;
import by.kozhevnikov.task1.service.impl.ArraySumServiceImpl;

import java.util.Comparator;

public class CustomArraySumComparator implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray a, CustomArray b) {

    ArraySumServiceImpl sumService = new ArraySumServiceImpl();

    return Integer.compare(sumService.calculate(a), sumService.calculate(b));
  }
}
