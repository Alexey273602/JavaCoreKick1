package by.kozhevnikov.task1.warehouse;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.entity.CustomArrayStatistics;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public interface Warehouse {
  static WarehouseImpl getInstance() {
    return null;
  }

  void update(CustomArray CustomArray);

  CustomArrayStatistics getStatistics(int arrayId);
}
