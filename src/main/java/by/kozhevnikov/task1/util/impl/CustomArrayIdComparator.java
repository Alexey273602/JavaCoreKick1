package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator  implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray a, CustomArray b) {
    return Integer.compare(a.getId(), b.getId());
  }
}
