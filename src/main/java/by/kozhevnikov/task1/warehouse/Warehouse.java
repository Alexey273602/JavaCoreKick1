package by.kozhevnikov.task1.warehouse;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.entity.MyArrayStatistics;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public interface Warehouse {
  static WarehouseImpl getInstance() {
    return null;
  }

  void update(MyArray myArray);

  MyArrayStatistics getStatistics(int arrayId);
}
