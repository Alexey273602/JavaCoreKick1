package by.kozhevnikov.task1.warehouse.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.entity.MyArrayStatistics;
import by.kozhevnikov.task1.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {

  private static WarehouseImpl INSTANCE;

  private final Map<Integer, MyArrayStatistics> statisticsMap = new HashMap<>();

  private WarehouseImpl() {
  }

  public static WarehouseImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new WarehouseImpl();
    }
    return INSTANCE;
  }

  public void update(MyArray myArray) {
    int[] data = myArray.getData();

    int sum = 0;
    int min = data[0];
    int max = data[0];

    for (int value : data) {
      sum += value;
      min = Math.min(min, value);
      max = Math.max(max, value);
    }

    double avg = (double) sum / data.length;

    MyArrayStatistics statistics = new MyArrayStatistics(sum, min, max, avg);
    statisticsMap.put(myArray.getId(), statistics);
  }

  public MyArrayStatistics getStatistics(int arrayId) {
    return statisticsMap.get(arrayId);
  }
}
