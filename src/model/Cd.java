package model;

public class Cd extends Product{

    public Cd(String naam) {
        super(naam);
        this.priceStrategy = new PriceCdStrategy();
    }

}
