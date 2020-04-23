package beers;

import org.junit.Assert;
import org.junit.Test;

public class TwentyFivePercentTest {

  @Test
  public void discount() {
    System.out.println("--- Test strategy TwentyFivePercent ---");

    /* initialize strategy */
    HappyHourStrategy twentyFivePercent = new TwentyFivePercent();

    /* initialize Beers */
    Beer ipa = new Beer("IPA", 5.0);


    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(twentyFivePercent);
    double ipaPrice = bob.calculatePrice(ipa);

    //assertEquals(double expected, double actual, double epsilon) 
    //where espilon is the maximum delta between expected and actual for which both numbers are still considered equal.
    Assert.assertEquals(3.75, ipaPrice, 0.0);
    System.out.println("Stratégie TwentyFivePercent validée");
  }
}
