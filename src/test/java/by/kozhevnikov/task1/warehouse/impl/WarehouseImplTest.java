package by.kozhevnikov.task1.warehouse.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.entity.MyArrayStatistics;
import by.kozhevnikov.task1.repository.impl.MyArrayRepositoryImpl;
import by.kozhevnikov.task1.warehouse.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseImplTest {

  @Test
  void testStatisticsAfterAdd() {
    MyArrayRepositoryImpl repository =
            MyArrayRepositoryImpl.getInstance();
    Warehouse warehouse = WarehouseImpl.getInstance();

    MyArray array = new MyArray(new int[]{1, 2, 3, 4});

    repository.add(array);

    MyArrayStatistics stats =
            warehouse.getStatistics(array.getId());

    assertNotNull(stats);
    assertEquals(10, stats.getSum());
    assertEquals(1, stats.getMin());
    assertEquals(4, stats.getMax());
    assertEquals(2.5, stats.getAverage());
  }

  @Test
  void testStatisticsUpdatedAfterChange() {
    MyArrayRepositoryImpl repository =
            MyArrayRepositoryImpl.getInstance();
    Warehouse warehouse = WarehouseImpl.getInstance();

    MyArray array = new MyArray(new int[]{2, 2, 2});
    repository.add(array);

    repository.updateElement(array.getId(), 1, 10);

    MyArrayStatistics stats =
            warehouse.getStatistics(array.getId());

    assertEquals(14, stats.getSum());
    assertEquals(2, stats.getMin());
    assertEquals(10, stats.getMax());
    assertEquals(14.0 / 3, stats.getAverage());
  }
}