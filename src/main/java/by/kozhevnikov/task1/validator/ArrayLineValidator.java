package by.kozhevnikov.task1.validator;

import by.kozhevnikov.task1.util.RegexConstant;

public class ArrayLineValidator {

  public boolean isValid(String line) {
    return line != null && line.matches(RegexConstant.VALID_LINE);
  }
}
