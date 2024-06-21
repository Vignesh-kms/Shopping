package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShoppingBasket {
    private static final Map<String,Double> fruitPrices=new HashMap<>();
    private final List<String> fruitsBasket;

    static{
        fruitPrices.put("Apple",0.35);
        fruitPrices.put("Banana",0.20);
        fruitPrices.put("Melon",0.50);
        fruitPrices.put("Lime",0.15);
    }

    public ShoppingBasket(List<String> fruitsBasket){
        this.fruitsBasket = fruitsBasket;
    }

    public double calculateTotalCost(){
        if(fruitsBasket.isEmpty()){
            System.out.println("Shopping Basket is Empty");
            return 0.00;
        }
        Map<String,Long> fruitCounter= fruitsBasket.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        double totalCost=0.0;
        for(Map.Entry<String,Long> fruitEntry:fruitCounter.entrySet()){
            String fruit=fruitEntry.getKey();
            Double price=fruitPrices.get(fruit);
            int fruitQuantity=fruitEntry.getValue().intValue();
            if(fruit.equals("Melon")){
                totalCost+=(fruitQuantity/2 + fruitQuantity%2)*price;
            }else if(fruit.equals("Lime")){
                totalCost+=((fruitQuantity/3)*2 + fruitQuantity %3)*price;
            }else{
                totalCost+=fruitQuantity*price;
            }
        }
        return totalCost;
    }
}
