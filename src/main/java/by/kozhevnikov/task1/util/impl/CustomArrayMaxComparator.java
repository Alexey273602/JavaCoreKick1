package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;
import by.kozhevnikov.task1.warehouse.Warehouse;

import java.util.Comparator;

public class CustomArrayMaxComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray a, CustomArray b) {

    ArrayMinMaxServiceImpl maxService = new ArrayMinMaxServiceImpl();

    return Integer.compare(maxService.max(a), maxService.max(b));

  }
}
