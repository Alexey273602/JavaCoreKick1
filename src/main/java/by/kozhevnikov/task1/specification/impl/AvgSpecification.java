package by.kozhevnikov.task1.specification.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.specification.ComparisonType;
import by.kozhevnikov.task1.specification.CustomArraySpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public class AvgSpecification implements CustomArraySpecification {

  private final ComparisonType type;
  private final int value;

  public AvgSpecification(ComparisonType type, int value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public boolean test(CustomArray array) {
    double average =  WarehouseImpl.getInstance()
            .getStatistics(array.getId())
            .getAverage();

    return switch (type) {
      case GREATER -> average > value;
      case LESS -> average < value;
      case EQUAL -> average == value;
    };
  }
}
