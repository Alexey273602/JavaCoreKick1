package by.kozhevnikov.task1.service;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.factory.impl.ArrayFactoryImpl;
import by.kozhevnikov.task1.reader.FileArrayReader;
import by.kozhevnikov.task1.validator.ArrayLineValidator;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFileServiceTest {

  private final FileArrayReader reader = new FileArrayReader();
  private final ArrayLineValidator validator = new ArrayLineValidator();

  @Test
  public void testCreateArrayFromFile() throws IOException {
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

    MyArray array = ArrayFactoryImpl.createArray(arrayData);

    assertArrayEquals(expected, array.get());
  }
}
