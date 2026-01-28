package by.kozhevnikov.task1.reader;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.exception.ArrayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileArrayReader {

  private static final Logger logger = LoggerFactory.getLogger(FileArrayReader.class);

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
