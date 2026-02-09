package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryImplCrudTest {

  private CustomArrayRepositoryImpl repository;

  @BeforeEach
  void setUp() {
    repository = CustomArrayRepositoryImpl.getInstance();
    repository.clear();
    WarehouseImpl.getInstance().clear();
  }

  @Test
  void add() throws ArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    repository.add(array);

    assertEquals(1, repository.getAll().size());
    assertEquals(array, repository.get(array.getId()));
  }

  @Test
  void remove() throws ArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2});
    CustomArray array2 = new CustomArray(new int[]{3, 4});

    repository.add(array1);
    repository.add(array2);

    repository.remove(array1.getId());

    assertEquals(1, repository.getAll().size());
    assertEquals(array2, repository.get(array2.getId()));
  }

  @Test
  void get() throws ArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 7});
    repository.add(array);

    CustomArray result = repository.get(array.getId());
    assertEquals(array, result);
  }

  @Test
  void getAll() throws ArrayException {
    CustomArray a1 = new CustomArray(new int[]{1});
    CustomArray a2 = new CustomArray(new int[]{2});
    CustomArray a3 = new CustomArray(new int[]{3});

    repository.add(a1);
    repository.add(a2);
    repository.add(a3);

    assertEquals(3, repository.getAll().size());
  }
}
