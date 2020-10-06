package model;

public class PriceCdStrategy implements PriceStrategy{
    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }
}
