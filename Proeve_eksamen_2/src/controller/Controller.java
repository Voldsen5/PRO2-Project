package controller;

import model.Pizza;
import storage.Storage;

public class Controller {
    public static Pizza createNewPizza(String name, double price){
        Pizza pizza = new Pizza(name, price);
        Storage.addPizza(pizza);
        return pizza;
    }

    //------------------------------------------------------------

    public static void initStorage(){
        createNewPizza("Pizza Margherita", 40);

        createNewPizza("Pizza Americana", 50);

        createNewPizza("Pizza Rustica", 60);

        createNewPizza("Pizza Primavera", 60);
    }
}
