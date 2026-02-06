package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.repository.CustomArrayRepository;
import by.kozhevnikov.task1.warehouse.Warehouse;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryImplTest {

  private CustomArrayRepositoryImpl repository;

  @BeforeEach
  void setUp() {
    repository = CustomArrayRepositoryImpl.getInstance();
    repository.clear();

  }

  @Test
  void add() {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    repository.add(array);

    assertEquals(1, repository.getAll().size());
    assertEquals(array, repository.get(0));
  }

  @Test
  void remove() {
    CustomArray array1 = new CustomArray(new int[]{1, 2});
    CustomArray array2 = new CustomArray(new int[]{3, 4});

    repository.add(array1);
    repository.add(array2);

    repository.remove(0);

    assertEquals(1, repository.getAll().size());
    assertEquals(array2, repository.get(0));
  }

  @Test
  void get() {
    CustomArray array = new CustomArray(new int[]{5, 6, 7});
    repository.add(array);

    CustomArray result = repository.get(0);

    assertEquals(array, result);
  }

  @Test
  void getAll() {

    repository.add(new CustomArray(new int[]{1}));
    repository.add(new CustomArray(new int[]{2}));
    repository.add(new CustomArray(new int[]{3}));

    assertEquals(3, repository.getAll().size());
  }
}