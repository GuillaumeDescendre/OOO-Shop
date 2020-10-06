package model;

public class PriceCdStrategy implements PriceStrategy{
    @Override
    public double getPrice(int days) {
        double price = days * 1.5;
        return price;
    }
}
