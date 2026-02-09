package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.specification.ComparisonType;
import by.kozhevnikov.task1.specification.impl.SumSpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomArrayRepositoryQueryTest {

  private CustomArrayRepositoryImpl repository;
  private WarehouseImpl warehouse;

  @BeforeEach
  void setUp() throws ArrayException {
    repository = CustomArrayRepositoryImpl.getInstance();
    repository.clear();
    warehouse = WarehouseImpl.getInstance();
    warehouse.clear();

    repository.add(new CustomArray(new int[]{1, 2, 3}));
    repository.add(new CustomArray(new int[]{10, 20, 30}));
    repository.add(new CustomArray(new int[]{5, 5}));
  }

  @Test
  void queryShouldReturnArraysWithSumGreaterThanValue() {
    SumSpecification spec = new SumSpecification(ComparisonType.GREATER, 10);

    List<CustomArray> result = repository.query(spec);

    assertEquals(1, result.size());
    assertEquals(60,
            warehouse.getStatistics(result.get(0).getId()).getSum());
  }

  @Test
  void queryShouldReturnArraysWithSumLessThanValue() {
    SumSpecification spec = new SumSpecification(ComparisonType.LESS, 10);

    List<CustomArray> result = repository.query(spec);

    assertEquals(1, result.size());
    assertEquals(6,
            warehouse.getStatistics(result.get(0).getId()).getSum());
  }

  @Test
  void queryShouldReturnArraysWithSumEqualToValue() {
    SumSpecification spec = new SumSpecification(ComparisonType.EQUAL, 10);

    List<CustomArray> result = repository.query(spec);

    assertEquals(1, result.size());
    assertEquals(10,
            warehouse.getStatistics(result.get(0).getId()).getSum());
  }

  @Test
  void queryShouldReturnEmptyListIfNoMatch() {
    SumSpecification spec = new SumSpecification(ComparisonType.GREATER, 100);

    List<CustomArray> result = repository.query(spec);

    assertTrue(result.isEmpty());
  }
}
