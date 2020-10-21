package model;

public class IsDamagedState implements State{
    Product product;

    public IsDamagedState(Product product){
        this.product = product;
    }

    @Override
    public void rentProduct() {
        throw new IllegalArgumentException("Theproduct is damaged");
    }

    @Override
    public void returnProduct() {
        throw new IllegalArgumentException("The product is not in your possession");
    }

    @Override
    public void repairProduct() {
        product.setState(product.isAvailableState);
    }
}
