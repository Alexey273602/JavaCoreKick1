package by.kozhevnikov.task1.util.impl;

import by.kozhevnikov.task1.entity.MyArray;

import java.util.Comparator;

public class MyArraySizeComparator implements Comparator<MyArray> {

  @Override
  public int compare(MyArray a, MyArray b) {
    return Integer.compare(a.getData().length, b.getData().length);
  }
}
