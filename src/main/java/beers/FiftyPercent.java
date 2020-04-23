package beers;

public class FiftyPercent implements HappyHourStrategy {

    public static final double DISCOUNT_COEFFICIENT = 0.50;

    @Override
    public double calculateNewPrice(Beer beer) {
        return beer.getPrice() * (1.0 - DISCOUNT_COEFFICIENT);
    }

}
