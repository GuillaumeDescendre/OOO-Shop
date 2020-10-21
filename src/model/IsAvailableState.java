package model;

public class IsAvailableState implements State{
    Product product;

    public IsAvailableState(Product product){
        this.product = product;
    }

    @Override
    public void rentProduct() {
        product.uitgeleend = true;
    }

    @Override
    public void returnProduct() {
        throw new IllegalArgumentException("Je kan geen product terugbrengen die je niet hebt uitgeleend");
    }

    @Override
    public void repairProduct() {
        throw new IllegalArgumentException("Het product is niet beschadigd");
    }

}
