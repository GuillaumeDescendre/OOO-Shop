package model;

public class PriceGameStrategy implements PriceStrategy{
    @Override
    public double getPrice(int days) {
        int price = days * 3;
        return price;
    }
}
