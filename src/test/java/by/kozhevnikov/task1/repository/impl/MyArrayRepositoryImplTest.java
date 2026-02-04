package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.repository.MyArrayRepository;
import by.kozhevnikov.task1.warehouse.Warehouse;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayRepositoryImplTest {

  private MyArrayRepositoryImpl repository;

  @BeforeEach
  void setUp() {
    repository = MyArrayRepositoryImpl.getInstance();
    repository.clear();

  }

  @Test
  void add() {
    MyArray array = new MyArray(new int[]{1, 2, 3});
    repository.add(array);

    assertEquals(1, repository.getAll().size());
    assertEquals(array, repository.get(0));
  }

  @Test
  void remove() {
    MyArray array1 = new MyArray(new int[]{1, 2});
    MyArray array2 = new MyArray(new int[]{3, 4});

    repository.add(array1);
    repository.add(array2);

    repository.remove(0);

    assertEquals(1, repository.getAll().size());
    assertEquals(array2, repository.get(0));
  }

  @Test
  void get() {
    MyArray array = new MyArray(new int[]{5, 6, 7});
    repository.add(array);

    MyArray result = repository.get(0);

    assertEquals(array, result);
  }

  @Test
  void getAll() {

    repository.add(new MyArray(new int[]{1}));
    repository.add(new MyArray(new int[]{2}));
    repository.add(new MyArray(new int[]{3}));

    assertEquals(3, repository.getAll().size());
  }
}