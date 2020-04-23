package beers;

import org.junit.Assert;
import org.junit.Test;

public class NoDiscountTest {

  @Test
  public void discount() {
    System.out.println("--- Test strategy NoDiscount ---");

    /* initialize strategy */
    HappyHourStrategy noDiscount = new NoDiscount();

    /* initialize Beers */
    Beer chouffe = new Beer("Chouffe", 3.0);


    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(noDiscount);
    double chouffePrice = bob.calculatePrice(chouffe);

    //assertEquals(double expected, double actual, double epsilon) 
    //where espilon is the maximum delta between expected and actual for which both numbers are still considered equal.
    Assert.assertEquals(3.0, chouffePrice, 0.0);
    System.out.println("Stratégie NoDiscount validée");
  }
}
