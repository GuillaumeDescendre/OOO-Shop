package model;

public class Movie extends Product{

    public Movie(String naam) {
        super(naam);
        this.priceStrategy = new PriceMovieStrategy();
    }


}
