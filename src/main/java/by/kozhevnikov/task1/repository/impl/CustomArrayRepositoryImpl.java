package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.repository.CustomArrayRepository;
import by.kozhevnikov.task1.util.impl.*;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {

  private static final CustomArrayRepositoryImpl INSTANCE = new CustomArrayRepositoryImpl();
  private final WarehouseImpl warehouse = WarehouseImpl.getInstance();

  private CustomArrayRepositoryImpl() {
  }

  public static CustomArrayRepositoryImpl getInstance() {
    return INSTANCE;
  }

  private final List<CustomArray> storage = new ArrayList<>();

  @Override
  public void add(CustomArray CustomArray) {
    storage.add(CustomArray);
    WarehouseImpl.getInstance().update(CustomArray);
  }


  @Override
  public void remove(int id) {
    storage.remove(id);
  }

  @Override
  public List<CustomArray> getAll() {
    return storage;
  }

  @Override
  public CustomArray get(int id) {
    return storage.get(id);
  }

  @Override
  public void sort(Comparator<CustomArray> comparator) {
    storage.sort(comparator);
  }


  public void updateElement(int arrayId, int index, int newValue) {
    CustomArray array = storage.get(arrayId);
    array.setElement(index, newValue);

    warehouse.update(array);
  }

  @Override
  public void clear(){
    storage.clear();
  }
}
