package beers;

import org.junit.Assert;
import org.junit.Test;

public class FiftyPercentTest {

  @Test
  public void discount() {
    System.out.println("--- Test strategy FiftyPercent ---");

    /* initialize strategy */
    HappyHourStrategy fiftyPercent = new FiftyPercent();

    /* initialize Beers */
    Beer guinness = new Beer("Guinness", 6.0);


    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(fiftyPercent);
    double guinnessPrice = bob.calculatePrice(guinness);

    //assertEquals(double expected, double actual, double epsilon) 
    //where espilon is the maximum delta between expected and actual for which both numbers are still considered equal.
    Assert.assertEquals(3.0, guinnessPrice, 0.0);
    System.out.println("Stratégie FiftyPercent validée");
  }
}
