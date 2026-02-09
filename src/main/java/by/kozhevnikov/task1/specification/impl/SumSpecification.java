package by.kozhevnikov.task1.specification.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.specification.ComparisonType;
import by.kozhevnikov.task1.specification.CustomArraySpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

public class SumSpecification implements CustomArraySpecification {

  private final ComparisonType type;
  private final int value;

  public SumSpecification(ComparisonType type, int value) {
    this.type = type;
    this.value = value;
  }

  @Override
  public boolean test(CustomArray array) {
    int sum = WarehouseImpl.getInstance()
            .getStatistics(array.getId())
            .getSum();

    return switch (type) {
      case GREATER -> sum > value;
      case LESS -> sum < value;
      case EQUAL -> sum == value;
    };
  }

}

