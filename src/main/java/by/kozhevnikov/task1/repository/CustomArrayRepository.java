package by.kozhevnikov.task1.repository;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.specification.CustomArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface CustomArrayRepository {

  void add(CustomArray CustomArray) throws ArrayException;

  void remove(int id) throws ArrayException;

  List<CustomArray> getAll();

  CustomArray get(int id) throws ArrayException;

  void updateElement(int arrayId, int index, int newValue) throws ArrayException;

  void sort(Comparator<CustomArray> comparator);

  void clear();

  List<CustomArray> query(CustomArraySpecification specification);
}
