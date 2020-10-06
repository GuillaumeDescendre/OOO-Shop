package model;

public abstract class Product {

    private int id;
    String naam;
    boolean uitgeleend;
    PriceStrategy priceStrategy;

    public Product(String naam){
        this.naam = naam;
        uitgeleend = false;
    }


    public void setPriceStrategy(PriceStrategy priceStrategy){
        this.priceStrategy = priceStrategy;
    }

    public void setUitgeleend(boolean uitgeleend) {
        this.uitgeleend = uitgeleend;
    }

    public boolean isUitgeleend() {
        return uitgeleend;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPrice(int days){
        return priceStrategy.getPrice(days);
    }

    public String getNaam() {
        return naam;
    }

    public String toString(){
        String ret =  " ID: " + id + " Naam: " + naam + " Type: " + getClass().getSimpleName();
        if(uitgeleend){
            ret += " | Niet beschikbaar";
        } else {
            ret += " | Beschikbaar";
        }
        return ret;
    }

}
