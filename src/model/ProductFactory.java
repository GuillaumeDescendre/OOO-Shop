package model;

import javax.swing.*;

public class ProductFactory {

    public Product createProduct(String name, String type){
        Product product = null;
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("name can't be empty!");
        }if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Not a valid type");
        }else if (type.equals("G")) {
                product = new Game(name);
             }
          else if (type.equals("C")) {
                product = new Cd(name);
            }
          else if (type.equals("M")) {
                product = new Movie(name);
            } else {
              throw new IllegalArgumentException("Wrong argument!");
        }
        System.out.println(product);
          product.setState(product.isAvailableState);
        return product;
    }


}
