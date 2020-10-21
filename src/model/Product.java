package model;

public abstract class Product {

    private int id;
    String naam;
    PriceStrategy priceStrategy;

    State isAvailableState, isRentedState, isDamagedState;
    State state;

    public Product(String naam){
        isAvailableState = new IsAvailableState(this);
        isRentedState = new IsRentedState(this);
        isDamagedState = new IsDamagedState(this);
        this.naam = naam;
    }

    public void rentProduct(){
        state.rentProduct();
    }
    public void returnProduct(){
        state.returnProduct();
    }
    public void repairProduct(){
        state.repairProduct();
    }
    void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }

    public State getIsAvailableState() {
        return isAvailableState;
    }
    public State getIsDamagedState() {
        return isDamagedState;
    }
    public State getIsRentedState() {
        return isRentedState;
    }

    public void setId(int size) {
        System.out.println("Size: " + size);
        this.id = size;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy){
        this.priceStrategy = priceStrategy;
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
        if(getState() == isAvailableState){
            ret += " | beschikbaar";
        } else {
            ret += " | Niet Beschikbaar";
        }
        return ret;
    }

}
