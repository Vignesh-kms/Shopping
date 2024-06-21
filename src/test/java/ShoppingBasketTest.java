import org.example.ShoppingBasket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ShoppingBasketTest {

    @Test
    public void testCalculateTotalCostBoughtWithOffers(){
        List<String> basket= Arrays.asList("Apple","Banana","Melon","Melon","Lime","Lime","Lime");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertEquals(1.35,shoppingBasket.calculateTotalCost(),0.01);
    }

    @Test
    public void testCalculateTotalCostBoughtWithoutOffers(){
        List<String> basket= Arrays.asList("Apple","Banana","Melon","Lime");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertEquals(1.20,shoppingBasket.calculateTotalCost(),0.01);
    }

    @Test
    public void testCalculateTotalCostExpectFailureScenario(){
        List<String> basket= Arrays.asList("Apple","Apple","Apple");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertNotEquals(0.70, shoppingBasket.calculateTotalCost(), 0.01);
    }

    @Test
    public void testCalculateCostForEmptyBasket(){
        List<String> basket= Arrays.asList();
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertEquals(0.0,shoppingBasket.calculateTotalCost(),0.01);
    }

    @Test
    public void testCalculateTotalCostOffersForLime(){
        List<String> basket= Arrays.asList("Lime","Lime","Lime");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertEquals(0.30, shoppingBasket.calculateTotalCost(), 0.01);
    }


    @Test
    public void testCalculateTotalCostOffersForMelon(){
        List<String> basket= Arrays.asList("Melon","Melon","Melon");
        ShoppingBasket shoppingBasket=new ShoppingBasket(basket);
        Assertions.assertEquals(1.0, shoppingBasket.calculateTotalCost(), 0.01);
    }
}
