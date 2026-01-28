package by.kozhevnikov.task1.service.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.service.ArrayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArraySumServiceImpl implements ArrayService {

  private static final Logger logger =
          LoggerFactory.getLogger(ArraySumServiceImpl.class);

  @Override
  public int calculate(MyArray array) {
    int sum = 0;
    int[] elements = array.getData();

    for (int element : elements) {
      sum += element;
    }

    logger.debug("Сумма элементов массива = {}", sum);
    return sum;
  }
}
