package model;

public class PriceGameStrategy implements PriceStrategy{
    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
