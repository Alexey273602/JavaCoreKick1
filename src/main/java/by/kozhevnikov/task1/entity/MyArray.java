package by.kozhevnikov.task1.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MyArray {

  private static final Logger logger =
          LoggerFactory.getLogger(MyArray.class);

  private int id;

  private static int idCounter = 0;

  private Warehouse warehouse;

  private final int[] data;

  public MyArray(int[] data) {
    this.id = idCounter++;
    this.data = data;
    this.warehouse = new Warehouse(this);
    logger.info("MyArray создан, размер массива = {}", data.length);
  }

  public int[] getData() {
    return data.clone();
  }

  public Warehouse getWarehouse() {
    return warehouse;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MyArray myArray = (MyArray) o;
    return Arrays.equals(data, myArray.data);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(data);
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("MyArray{");
    sb.append("data=");
    if (data == null) sb.append("null");
    else {
      sb.append('[');
      for (int i = 0; i < data.length; ++i)
        sb.append(i == 0 ? "" : ", ").append(data[i]);
      sb.append(']');
    }
    sb.append('}');
    return sb.toString();
  }
}
