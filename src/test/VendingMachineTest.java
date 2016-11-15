import main.kata1.Coin;
import main.kata1.VendingMachine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by a225940 on 2016-11-08.
 */
public class VendingMachineTest
{

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private VendingMachine vendingMachine;

  @Before
  public void setUp()
  {
    vendingMachine = new VendingMachine();
  }

  @Test
  public void shouldAcceptNickelDimeAndQuarterCoin()
  {
    Coin nickel = new Coin(5, 5);
    Coin dime = new Coin(10, 10);
    Coin quarter = new Coin(25, 25);
    vendingMachine.putCoin(nickel);
    vendingMachine.putCoin(dime);
    vendingMachine.putCoin(quarter);
    Assert.assertEquals("40", vendingMachine.displayBalance());
  }

  @Test
  public void shouldRejectPenny()
  {
    expectedException.expect(RuntimeException.class);
    expectedException.expectMessage("Incorrect coin inserted!");
    Coin penny = new Coin(1, 1);
    vendingMachine.putCoin(penny);
  }

  @Test
  public void shouldRejectFiftyCent()
  {
    expectedException.expect(RuntimeException.class);
    expectedException.expectMessage("Incorrect coin inserted!");
    vendingMachine.putCoin(new Coin(50, 50));
  }

  @Test
  public void shouldDisplayBalance()
  {
    Assert.assertEquals("INSERT COIN", vendingMachine.displayBalance());
  }

}
