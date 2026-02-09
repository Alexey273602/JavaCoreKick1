package by.kozhevnikov.task1.warehouse.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.entity.CustomArrayStatistics;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {

  private static WarehouseImpl INSTANCE;

  private final Map<Integer, CustomArrayStatistics> statisticsMap = new HashMap<>();

  private WarehouseImpl() {
  }

  public static WarehouseImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new WarehouseImpl();
    }
    return INSTANCE;
  }

  public void update(CustomArray CustomArray) throws ArrayException {

    int[] data = CustomArray.getData();

    if (data.length == 0) {
      throw new ArrayException("Array is empty");
    }

    int sum = 0;
    int min = data[0];
    int max = data[0];

    for (int value : data) {
      sum += value;
      min = Math.min(min, value);
      max = Math.max(max, value);
    }

    double avg = (double) sum / data.length;

    CustomArrayStatistics statistics = new CustomArrayStatistics(sum, min, max, avg);
    statisticsMap.put(CustomArray.getId(), statistics);
  }

  public CustomArrayStatistics getStatistics(int arrayId) {
    return statisticsMap.get(arrayId);
  }

  @Override
  public void clear() {
    statisticsMap.clear();
  }
}
