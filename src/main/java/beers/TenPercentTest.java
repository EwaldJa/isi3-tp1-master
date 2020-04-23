package beers;

import org.junit.Assert;
import org.junit.Test;

public class TenPercentTest {

  @Test
  public void discount() {
    System.out.println("--- Test strategy TenPercent ---");

    /* initialize strategy */
    HappyHourStrategy tenPercent = new TenPercent();

    /* initialize Beers */
    Beer paleAle = new Beer("Pale Ale", 4.0);


    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(tenPercent);
    double paleAlePrice = bob.calculatePrice(paleAle);

    //assertEquals(double expected, double actual, double epsilon) 
    //where espilon is the maximum delta between expected and actual for which both numbers are still considered equal.
    Assert.assertEquals(3.6, paleAlePrice, 0.0);
    System.out.println("Stratégie TenPercent validée");
  }
}
