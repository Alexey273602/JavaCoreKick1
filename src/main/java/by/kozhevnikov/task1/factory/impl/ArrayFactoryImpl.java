package by.kozhevnikov.task1.factory.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.factory.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ArrayFactoryImpl implements ArrayFactory {

  private static final Logger logger = LoggerFactory.getLogger(ArrayFactoryImpl.class);

  private ArrayFactoryImpl() {
  }

  public static MyArray createArray(int[] elements) {
    logger.info("Создаём MyArray, длина = {}", elements.length);
    return new MyArray(elements);
  }

}
