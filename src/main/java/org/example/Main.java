package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> basket= Arrays.asList("Banana","Apple","Melon","Melon","Melon");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        System.out.println("Total cost: "+String.format("%.2f", shoppingBasket.calculateTotalCost())+" GBP");
    }
}