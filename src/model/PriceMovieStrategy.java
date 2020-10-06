package model;

public class PriceMovieStrategy implements PriceStrategy {
    @Override
    public double getPrice(int days) {
        int price = 5;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            price += (daysLeft * 2);
        }
        return price;
    }
}
