package main.kata1;

import java.util.function.Predicate;

import static java.util.Arrays.stream;

/**
 * Created by a225940 on 2016-11-08.
 */
public class VendingMachine
{

  private int balance;

  public void putCoin(Coin coinValue)
  {
    balance += Coins.getByWeightAndSize(coinValue.getWeight(), coinValue.getSize());
  }

  public String displayBalance()
  {
    return balance == 0 ? "INSERT COIN" : String.valueOf(balance);
  }

  enum Coins
  {

    NICKEL(5, 5, 5), DIME(10, 10, 10), QUARTER(25, 25, 25);

    private final int value;
    private final int weight;
    private final int size;

    Coins(int value, int weight, int size)
    {
      this.value = value;
      this.weight = weight;
      this.size = size;
    }

    public static int getByWeightAndSize(int weight, int size)
    {
      return stream(Coins.values()).filter(isMatchedByWeightAndSize(weight, size)).findFirst()
          .orElseThrow(() -> new RuntimeException("Incorrect coin inserted!")).value;
    }

    private static Predicate<Coins> isMatchedByWeightAndSize(int weight, int size)
    {
      return coins -> weight == coins.weight && coins.size == size;
    }
  }
}
