package by.kozhevnikov.task1.specification.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.specification.ComparisonType;
import by.kozhevnikov.task1.specification.CustomArraySpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public class MaxSpecification implements CustomArraySpecification {

  private final ComparisonType type;
  private final int value;

  public MaxSpecification(ComparisonType type, int value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public boolean test(CustomArray array) {
    int max = WarehouseImpl.getInstance()
            .getStatistics(array.getId())
            .getMax();

    return switch (type) {
      case GREATER -> max > value;
      case LESS -> max < value;
      case EQUAL -> max == value;
    };
  }
}
