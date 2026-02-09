package by.kozhevnikov.task1.repository.impl;

import by.kozhevnikov.task1.entity.CustomArray;
import by.kozhevnikov.task1.exception.ArrayException;
import by.kozhevnikov.task1.repository.CustomArrayRepository;
import by.kozhevnikov.task1.specification.CustomArraySpecification;
import by.kozhevnikov.task1.warehouse.impl.WarehouseImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {

  private static final CustomArrayRepositoryImpl INSTANCE =
          new CustomArrayRepositoryImpl();

  private final List<CustomArray> storage = new ArrayList<>();
  private final WarehouseImpl warehouse = WarehouseImpl.getInstance();

  private CustomArrayRepositoryImpl() {}

  public static CustomArrayRepositoryImpl getInstance() {
    return INSTANCE;
  }

  @Override
  public void add(CustomArray array) throws ArrayException {
    storage.add(array);
    warehouse.update(array);
  }

  @Override
  public void remove(int id) throws ArrayException {
    CustomArray array = findById(id);
    storage.remove(array);
  }

  @Override
  public CustomArray get(int id) throws ArrayException {
    return findById(id);
  }

  @Override
  public List<CustomArray> getAll() {
    return storage;
  }

  @Override
  public void sort(Comparator<CustomArray> comparator) {
    storage.sort(comparator);
  }

  public void updateElement(int arrayId, int index, int newValue)
          throws ArrayException {

    CustomArray array = findById(arrayId);
    array.setElement(index, newValue);
    warehouse.update(array);
  }

  @Override
  public void clear() {
    storage.clear();
  }

  public List<CustomArray> query(CustomArraySpecification specification) {
    List<CustomArray> result = new ArrayList<>();
    for (CustomArray array : storage) {
      if (specification.test(array)) {
        result.add(array);
      }
    }
    return result;
  }

  private CustomArray findById(int id) throws ArrayException {
    return storage.stream()
            .filter(array -> array.getId() == id)
            .findFirst()
            .orElseThrow(() ->
                    new ArrayException("CustomArray with id " + id + " not found"));
  }
}
