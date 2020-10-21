package UI;

import model.*;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WinkelUI {


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("shop.txt"));
        input.useDelimiter("-|\n");
        Winkel winkel = new Winkel("OOO-Winkel");
        ProductFactory productFactory = new ProductFactory();


        while(input.hasNext()) {

            try {
                String type = input.next();
                String name = input.next();
                Product product = productFactory.createProduct(name, type);
                winkel.addProduct(product);
            }    catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }

    }


        String menu = "1. Add product\n2. Delete product \n3. Show all products\n4. Show product on id\n5. Show rental price\n6. Reserve product\n7. Check availability on id\n\n\n0. Quit and save";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice > 7) {
                JOptionPane.showMessageDialog(null, "Geen geldige keuze!", "Error", JOptionPane.ERROR_MESSAGE);
            }


            if (choice == 1) {
                String title = JOptionPane.showInputDialog("Enter the product title:");
                String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");
                try {
                    Product product = productFactory.createProduct(title, type);
                    winkel.addProduct(product);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 2) {
                String id = JOptionPane.showInputDialog("Enter the product ID to delete: ");
                try {
                    int productid = Integer.parseInt(id);
                    Product selectedproduct = winkel.getProductById(productid);
                    String check = JOptionPane.showInputDialog(selectedproduct.toString() + "\n Are you sure you want to delete this product? (Y/N)");
                    if (check.equals("Y") || check.equals("y")) {
                        winkel.deleteProductonId(productid);
                        JOptionPane.showMessageDialog(null, "Product deleted!", "info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Product remains!!", "info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 3) {
                ArrayList films = winkel.getFilms();
                ArrayList games = winkel.getGames();
                ArrayList cds = winkel.getCDs();

                String filmoverview = winkel.ArraytoStringOverview(films);
                String gamesoverview = winkel.ArraytoStringOverview(games);
                String cdsoverview = winkel.ArraytoStringOverview(cds);
                String overview = "Films (" + films.size() + ")\n" + filmoverview + "\nGames (" + games.size() + ")\n" + gamesoverview + "\nCD's (" + cds.size() + ")\n" + cdsoverview;

                JOptionPane.showMessageDialog(null, overview, "Products", JOptionPane.INFORMATION_MESSAGE);
            }


            if (choice == 4) {
                String id = JOptionPane.showInputDialog("Enter the product ID");
                try {
                    int idx = Integer.parseInt(id);
                    Product selectedproduct = winkel.getProductById(idx);
                    JOptionPane.showMessageDialog(null, selectedproduct.toString(), "Product " + id, JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 5) {
                String id = JOptionPane.showInputDialog("Enter the product ID");
                try {
                    int productid = Integer.parseInt(id);
                    Product selectedproduct = winkel.getProductById(productid);
                    String dagen = JOptionPane.showInputDialog(selectedproduct.toString() + "\n How many days?");
                    int days = Integer.parseInt(dagen);
                    double prijs = winkel.getProductById(productid).getPrice(days);
                    JOptionPane.showMessageDialog(null, prijs + " €", "Product " + id, JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 6) {
                String id = JOptionPane.showInputDialog("Enter the product ID you want to reserve:");
                try {
                    int productid = Integer.parseInt(id);
                    Product selectedproduct = winkel.getProductById(productid);
                    selectedproduct.rentProduct();
                    }
                 catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 7) {
                String id = JOptionPane.showInputDialog("Enter the product ID: ");
                try {
                    int productid = Integer.parseInt(id);
                    Product selectedproduct = winkel.getProductById(productid);
                    if (selectedproduct.getState() == selectedproduct.getIsDamagedState() || selectedproduct.getState() == selectedproduct.getIsRentedState()) {
                        JOptionPane.showMessageDialog(null, "ID: " + selectedproduct.getId() + " Naam: " + selectedproduct.getNaam() + "\nNot available!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID: " + selectedproduct.getId() + " Naam: " + selectedproduct.getNaam() + "\nAvailable!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (choice == 0){
                FileWriter writer = new FileWriter("shop.txt");
                ArrayList<Movie> movies = winkel.getFilms();
                ArrayList<Game> games = winkel.getGames();
                ArrayList<Cd> cds = winkel.getCDs();
                for (Movie m: movies) {
                    writer.write("M"+m.getNaam()+"\n");
                }
                for (Game g: games) {
                    writer.write("G"+g.getNaam()+"\n");
                }
                for (Cd c: cds) {
                    writer.write("C"+c.getNaam()+"\n");
                }
                writer.close();
            }
        }
    }
}

