package by.kozhevnikov.task1.service;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.factory.impl.ArrayFactoryImpl;
import by.kozhevnikov.task1.service.impl.ArrayMinMaxServiceImpl;
import by.kozhevnikov.task1.service.impl.ArraySumServiceImpl;
import by.kozhevnikov.task1.service.impl.SortServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CustomArrayServiceTest {

  private final ArrayMinMaxServiceImpl minMaxService = new ArrayMinMaxServiceImpl();
  private final ArraySumServiceImpl sumService = new ArraySumServiceImpl();
  private final SortServiceImpl sortService = new SortServiceImpl();

  @Test
  public void testSum() {
    CustomArray array = ArrayFactoryImpl.createArray(new int[]{1, 2, 3, 4});
    int sum = sumService.calculate(array);
    assertEquals(10, sum);
  }

  @Test
  public void testMinMax() {
    CustomArray array = ArrayFactoryImpl.createArray(new int[]{5, 2, 9, 1});
    assertEquals(1, minMaxService.min(array));
    assertEquals(9, minMaxService.max(array));
  }

  @Test
  public void testInsertionSortFunctional() {
    CustomArray array = ArrayFactoryImpl.createArray(new int[]{4, 1, 3, 2});
    int[] sorted = sortService.insertSort(array);
    assertArrayEquals(new int[]{1, 2, 3, 4}, sorted);
  }

  @Test
  public void testQuickSortFunctional() {
    CustomArray array = ArrayFactoryImpl.createArray(new int[]{4, 1, 3, 2});
    int[] sorted = sortService.quickSort(array);
    assertArrayEquals(new int[]{1, 2, 3, 4}, sorted);
  }

}
