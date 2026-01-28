package by.kozhevnikov.task1.repository;

import by.kozhevnikov.task1.entity.MyArray;

import java.util.List;

public interface MyArrayRepository {

  void add(MyArray myArray);

  void remove(int id);

  List<MyArray> getAll();

  MyArray get(int id);

  void sortById();

  void sortByMax();

  void sortByMin();

  void sortBySum();

  void sortBySize();


}
