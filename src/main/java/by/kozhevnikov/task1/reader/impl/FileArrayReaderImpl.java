package by.kozhevnikov.task1.reader.impl;

import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.reader.FileArrayReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileArrayReaderImpl implements FileArrayReader {

  private static final Logger logger = LoggerFactory.getLogger(FileArrayReaderImpl.class);

  public List<String> readLines(String filePath) throws ArrayException {
    Path path = Path.of(filePath);
    try {
      logger.info("Читается файл: {}", path);
      return Files.readAllLines(path);
    } catch (Exception arrayException) {
      logger.error("Ошибка чтения файла: {}", path, arrayException);
      throw new ArrayException("Ошибка чтения файла: " + path);
    }
  }

}
