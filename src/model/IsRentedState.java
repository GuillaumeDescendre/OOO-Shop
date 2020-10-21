package model;

public class IsRentedState implements State{
    Product product;

    public IsRentedState(Product product){
        this.product = product;
    }

    @Override
    public void rentProduct() {
        throw new IllegalArgumentException("product is already in someone else possession");
    }

    @Override
    public void returnProduct() {
        product.uitgeleend = false;
        double damageFactor = (int)(Math.random() * ((4 - 1) + 1)) + 1;
        if(damageFactor == 1){
            product.damaged = true;
        }
    }

    @Override
    public void repairProduct() {
        throw new IllegalArgumentException("Product is not returned yet");
    }
}
