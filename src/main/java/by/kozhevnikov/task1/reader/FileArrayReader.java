package by.kozhevnikov.task1.reader;

import by.kozhevnikov.task1.exception.ArrayException;

import java.util.List;

public interface FileArrayReader {
  List<String> readLines(String filePath) throws ArrayException;
}
