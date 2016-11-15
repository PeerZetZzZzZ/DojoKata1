package main.kata1;

/**
 * Created by a225940 on 2016-11-08.
 */
public class Coin
{
  private int weight;
  private int size;

  public Coin(int weight, int size)
  {
    this.weight = weight;
    this.size = size;
  }

  public int getWeight()
  {
    return weight;
  }

  public void setWeight(int weight)
  {
    this.weight = weight;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }
}
