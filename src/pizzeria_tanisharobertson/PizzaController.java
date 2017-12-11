/**
 * Takes Pizza order and saves to database
 * 11 Dec 2017
 * CSC 251 Project 2 -Pizzeria
 * @author Tanisha Robertson
 */
package pizzeria_tanisharobertson;

import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

public class PizzaController
{

    @FXML
    private CheckBox sausageTop;

    @FXML
    private CheckBox hamTop;

    @FXML
    private RadioButton extraLargePizza;

    @FXML
    private CheckBox onionsTop;

    @FXML
    private CheckBox extraCheeseTop;

    @FXML
    private CheckBox pepperoniTop;

    @FXML
    private RadioButton thinCrust;

    @FXML
    private RadioButton gutBusterCrust;

    @FXML
    private RadioButton largePizza;

    @FXML
    private RadioButton stuffedCrust;

    @FXML
    private CheckBox hamburgerTop;

    @FXML
    private RadioButton mediumPizza;

    @FXML
    private CheckBox chickenTop;

    @FXML
    private CheckBox blackOlivesTop;

    @FXML
    private RadioButton deepDishCrust;

    @FXML
    private ToggleGroup sizeGroup;

    @FXML
    private CheckBox mushtoomsTop;

    @FXML
    private RadioButton smallPizza;

    @FXML
    private CheckBox greenPeppersTop;

    @FXML
    private RadioButton handTossedCrust;

    @FXML
    private CheckBox baconTop;

    @FXML
    private Button orderButton;

    @FXML
    private ToggleGroup crustGroup;

    double cost;
    String size;
    String crustStyleVar;
    String toppingList;

    public void initialize() {
        double cost = 0.0; 
        size = "";
        crustStyleVar = "";
        toppingList = "Toppings: ";
    }
    
    // submit button for listener 
    public void submitButtonListener() {
        
        // picking your size
        
        if (smallPizza.isSelected() == true) {
            cost += 7;
            size = "Small";
        }
        else if (mediumPizza.isSelected() == true) {
            cost += 9;
            size = "Medium";
        }
        else if (largePizza.isSelected() == true) {
            cost += 11;
            size = "Large";
        }
        else if (extraLargePizza.isSelected() == true) {
            cost += 13;
            size = "Extra Large";
        }
        
        // picking your crust
        
        if (handTossedCrust.isSelected() == true) {
            crustStyleVar = "Hand Tossed";
        }
        else if (thinCrust.isSelected() == true) {
            crustStyleVar = "Thin Crust";
        }
        else if (gutBusterCrust.isSelected() == true) {
            crustStyleVar = "Gut Buster";
        }
        else if (stuffedCrust.isSelected() == true) {
            crustStyleVar = "Stuffed Crust";
        }
        else if (deepDishCrust.isSelected() == true) {
            crustStyleVar = "Deep Dish";
        }
        
        // picking your toppings
        
        if (pepperoniTop.isSelected() == true) {
            cost += .5;
            toppingList += "Pepperoni, ";
        }
        
        if (sausageTop.isSelected() == true) {
            cost += .5;
            toppingList += "Sausage, ";
        }
        
        if (hamTop.isSelected() == true) {
            cost += .5;
            toppingList += "Ham, ";
        }
         
        if (baconTop.isSelected() == true) {
            cost += .5;
            toppingList += "Bacon, ";
        }
        
        if (chickenTop.isSelected() == true) {
            cost += .5;
            toppingList += "Chicken, ";
        }
        
        if (hamburgerTop.isSelected() == true) {
            cost += .5;
            toppingList += "Hamburger, ";
        }
        
        if (extraCheeseTop.isSelected() == true) {
            cost += .5;
            toppingList += "Extra Cheese, ";
        }
        
        if (onionsTop.isSelected() == true) {
            cost += .5;
            toppingList += "Onions, ";
        }
        
        if (greenPeppersTop.isSelected() == true) {
            cost += .5;
            toppingList += "Green Peppers, ";
        }
        
        if (mushtoomsTop.isSelected() == true) {
            cost += .5;
            toppingList += "Mushroom, ";
        }
        
        if (blackOlivesTop.isSelected() == true) {
            cost += .5;
            toppingList += "Black Olives, ";
        }
        
        
     
        System.out.println("Size: " + size);
        System.out.println("Crust Style: " + crustStyleVar);
        System.out.println(toppingList);
        System.out.println("Cost: $" + cost);
        
        try {
            OrderTableManager orderManager = new OrderTableManager();
            orderManager.insert(size, crustStyleVar, toppingList, cost);
            JOptionPane.showMessageDialog(null, "Order submitted!");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
    
}

   