package by.kozhevnikov.task1.repository;

import by.kozhevnikov.task1.entity.CustomArray;

import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {

  void add(CustomArray CustomArray);

  void remove(int id);

  List<CustomArray> getAll();

  CustomArray get(int id);

  void updateElement(int arrayId, int index, int newValue);

  void sort(Comparator<CustomArray> comparator);

  void clear();
}
