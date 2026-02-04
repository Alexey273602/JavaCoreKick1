package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.MyArray;
import by.kozhevnikov.task1.repository.MyArrayRepository;
import by.kozhevnikov.task1.util.impl.*;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

import java.util.ArrayList;
import java.util.List;

public class MyArrayRepositoryImpl implements MyArrayRepository {

  private static final MyArrayRepositoryImpl INSTANCE = new MyArrayRepositoryImpl();
  private final WarehouseImpl warehouse = WarehouseImpl.getInstance();

  private MyArrayRepositoryImpl() {
  }

  public static MyArrayRepositoryImpl getInstance() {
    return INSTANCE;
  }

  private final List<MyArray> storage = new ArrayList<>();

  @Override
  public void add(MyArray myArray) {
    storage.add(myArray);
    WarehouseImpl.getInstance().update(myArray);
  }


  @Override
  public void remove(int id) {
    storage.remove(id);
  }

  @Override
  public List<MyArray> getAll() {
    return storage;
  }

  @Override
  public MyArray get(int id) {
    return storage.get(id);
  }

  @Override
  public void sortById() {
    storage.sort(new MyArrayIdComparator());
  }

  @Override
  public void sortByMax() {
    storage.sort(new MyArrayMaxComparator());
  }

  @Override
  public void sortByMin() {
    storage.sort(new MyArrayMinComparator());
  }

  @Override
  public void sortBySum() {
    storage.sort(new MyArraySumComparator());
  }

  @Override
  public void sortBySize() {
    storage.sort(new MyArraySizeComparator());
  }

  public void updateElement(int arrayId, int index, int newValue) {
    MyArray array = storage.get(arrayId);
    array.setElement(index, newValue);

    warehouse.update(array);
  }

  @Override
  public void clear(){
    storage.clear();
  }
}
