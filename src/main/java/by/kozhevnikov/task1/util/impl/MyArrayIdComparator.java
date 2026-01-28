package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.MyArray;

import java.util.Comparator;

public class MyArrayIdComparator  implements Comparator<MyArray> {

  @Override
  public int compare(MyArray a, MyArray b) {
    return Integer.compare(a.getId(), b.getId());
  }
}
