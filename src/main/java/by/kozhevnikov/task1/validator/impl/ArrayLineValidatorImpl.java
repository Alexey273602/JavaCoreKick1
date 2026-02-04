package by.kozhevnikov.task1.validator.impl;

import by.kozhevnikov.task1.validator.ArrayLineValidator;

public class ArrayLineValidatorImpl implements ArrayLineValidator {

  String VALID_LINE_REGEX = "^\\s*([-]?\\d+([,;\\s-]+[-]?\\d+)*)?\\s*$";

  public boolean isValid(String line) {
    return line != null && line.matches(VALID_LINE_REGEX);
  }
}
