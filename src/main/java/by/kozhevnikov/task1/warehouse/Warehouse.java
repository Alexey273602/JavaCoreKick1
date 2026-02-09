package by.kozhevnikov.task1.warehouse;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.entity.CustomArrayStatistics;
import by.kozhevnikov.task1.exception.ArrayException;


public interface Warehouse {

  void update(CustomArray CustomArray) throws ArrayException;

  CustomArrayStatistics getStatistics(int arrayId);

  void clear();
}
