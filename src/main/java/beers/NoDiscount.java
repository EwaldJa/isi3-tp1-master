package beers;

public class NoDiscount implements HappyHourStrategy {

    public static final double DISCOUNT_COEFFICIENT = 0.00;

    @Override
    public double calculateNewPrice(Beer beer) {
        return beer.getPrice() * (1.0 - DISCOUNT_COEFFICIENT);
    }

}
