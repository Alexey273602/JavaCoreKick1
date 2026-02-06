package by.kozhevnikov.task1.service.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.service.ArrayMinMaxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayMinMaxServiceImpl implements ArrayMinMaxService {

  private static final Logger logger =
          LoggerFactory.getLogger(ArrayMinMaxServiceImpl.class);

  @Override
  public int min(CustomArray array) {
    int[] elements = array.getData();
    int min = elements[0];

    for (int element : elements) {
      if (element < min) {
        min = element;
      }
    }

    logger.debug("Минимальное значение массива = {}", min);
    return min;
  }

  @Override
  public int max(CustomArray array) {
    int[] elements = array.getData();
    int max = elements[0];

    for (int element : elements) {
      if (element > max) {
        max = element;
      }

    }

    logger.debug("Максимальное значение массива = {}", max);
    return max;
  }
}
