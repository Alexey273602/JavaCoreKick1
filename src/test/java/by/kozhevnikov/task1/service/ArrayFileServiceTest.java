package by.kozhevnikov.task1.service;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.factory.impl.ArrayFactoryImpl;
import by.kozhevnikov.task1.reader.impl.FileArrayReaderImpl;
import by.kozhevnikov.task1.validator.impl.ArrayLineValidatorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFileServiceTest {

  private final FileArrayReaderImpl reader = new FileArrayReaderImpl();
  private final ArrayLineValidatorImpl validator = new ArrayLineValidatorImpl();

  @Test
  public void testCreateArrayFromFile() throws ArrayException {
    String filePath = "src/test/resources/test-array.txt";

    List<String> lines = reader.readLines(filePath);
    List<Integer> numbers = new ArrayList<>();

    for (String line : lines) {
      if (!validator.isValid(line)) continue;

      String[] tokens = line.trim().split("[,;\\s]+");
      for (String token : tokens) {
        if (!token.isEmpty()) numbers.add(Integer.parseInt(token));
      }
    }

    int[] expected = {1, 2, 3, 4, 5, 6, 7, -1, -2, -3};
    int[] arrayData = numbers.stream().mapToInt(Integer::intValue).toArray();

    CustomArray array = ArrayFactoryImpl.createArray(arrayData);

    assertArrayEquals(expected, array.getData());
  }
}
