package model;

public class Game extends Product {

    public Game(String naam) {
        super(naam);
        this.priceStrategy = new PriceGameStrategy();
    }


}
