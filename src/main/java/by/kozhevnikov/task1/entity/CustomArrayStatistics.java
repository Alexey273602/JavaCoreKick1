package by.kozhevnikov.task1.entity;

public class CustomArrayStatistics {

  private int sum;
  private int min;
  private int max;
  private double average;

  public CustomArrayStatistics(int sum, int min, int max, double average) {
    this.sum = sum;
    this.min = min;
    this.max = max;
    this.average = average;
  }

  public int getSum() {
    return sum;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public double getAverage() {
    return average;
  }
}
