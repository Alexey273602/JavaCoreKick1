package by.kozhevnikov.task1.exception;

public class ArrayException extends Exception {

  public ArrayException(String message) {
    super(message);
  }

  public ArrayException(String message, Exception e) {
    super(message, e);
  }

}
