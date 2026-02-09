package by.kozhevnikov.task1.specification.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.specification.ComparisonType;
import by.kozhevnikov.task1.specification.CustomArraySpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public class MinSpecification implements CustomArraySpecification {

  private final ComparisonType type;
  private final int value;

  public MinSpecification(ComparisonType type, int value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public boolean test(CustomArray array) {
    int min = WarehouseImpl.getInstance()
            .getStatistics(array.getId())
            .getMin();

    return switch (type) {
      case GREATER -> min >  value;
      case LESS -> min < value;
      case EQUAL -> min == value;
    };
  }
}
