package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;

import java.util.Comparator;

public class CustomArrayMinComparator implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray a, CustomArray b) {
    ArrayMinMaxServiceImpl minService = new ArrayMinMaxServiceImpl();

    return Integer.compare(minService.min(a), minService.min(b));
  }
}
