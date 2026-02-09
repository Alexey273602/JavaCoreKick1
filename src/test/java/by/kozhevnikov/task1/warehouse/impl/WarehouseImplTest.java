package by.kozhevnikov.task1.warehouse.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.entity.CustomArrayStatistics;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.repository.impl.CustomArrayRepositoryImpl;
import by.kozhevnikov.task1.warehouse.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseImplTest {

  @Test
  void testStatisticsAfterAdd() throws ArrayException {
    CustomArrayRepositoryImpl repository =
            CustomArrayRepositoryImpl.getInstance();
    Warehouse warehouse = WarehouseImpl.getInstance();

    CustomArray array = new CustomArray(new int[]{1, 2, 3, 4});

    repository.add(array);

    CustomArrayStatistics stats =
            warehouse.getStatistics(array.getId());

    assertNotNull(stats);
    assertEquals(10, stats.getSum());
    assertEquals(1, stats.getMin());
    assertEquals(4, stats.getMax());
    assertEquals(2.5, stats.getAverage());
  }

  @Test
  void testStatisticsUpdatedAfterChange() throws ArrayException {
    CustomArrayRepositoryImpl repository =
            CustomArrayRepositoryImpl.getInstance();
    Warehouse warehouse = WarehouseImpl.getInstance();

    CustomArray array = new CustomArray(new int[]{2, 2, 2});
    repository.add(array);

    repository.updateElement(array.getId(), 1, 10);

    CustomArrayStatistics stats =
            warehouse.getStatistics(array.getId());

    assertEquals(14, stats.getSum());
    assertEquals(2, stats.getMin());
    assertEquals(10, stats.getMax());
    assertEquals(14.0 / 3, stats.getAverage());
  }
}