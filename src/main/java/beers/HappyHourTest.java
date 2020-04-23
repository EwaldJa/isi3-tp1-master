package beers;

import org.junit.Assert;
import org.junit.Test;

public class HappyHourTest {

  @Test
  public void orders() {

    System.out.println("=== pattern strategy ===");

    /* initialize strategy */
    HappyHourStrategy noDiscount = new NoDiscount();
    HappyHourStrategy tenPercent = new TenPercent();
    HappyHourStrategy twentyFivePercent = new TwentyFivePercent();
    HappyHourStrategy fiftyPercent = new FiftyPercent();

    /* initialize Beers */
    Beer chouffe = new Beer("Chouffe", 3.0);
    Beer paleAle = new Beer("Pale Ale", 4.0);
    Beer ipa = new Beer("IPA", 5.0);
    Beer guinness = new Beer("Guiness", 6.0);


    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(noDiscount);
    double paleAlePrice = bob.calculatePrice(paleAle);

    bob.setStrategy(tenPercent);
    double chouffePrice = bob.calculatePrice(chouffe);

    bob.setStrategy(twentyFivePercent);
    double ipaPrice = bob.calculatePrice(ipa);

    bob.setStrategy(fiftyPercent);
    double guinnessPrice = bob.calculatePrice(guinness);

    //assertEquals(double expected, double actual, double epsilon) 
    //where espilon is the maximum delta between expected and actual for which both numbers are still considered equal.
    Assert.assertEquals(4.0, paleAlePrice, 0.0);
    System.out.println("Stratégie NoDiscount validée");
    Assert.assertEquals(2.7, chouffePrice, 0.0);
    System.out.println("Stratégie TenPercent validée");
    Assert.assertEquals(3.75, ipaPrice,  0.0);
    System.out.println("Stratégie TwentyFivePercent validée");
    Assert.assertEquals(3.0, guinnessPrice,  0.0);
    System.out.println("Stratégie FiftyPercent validée");


  }
}
