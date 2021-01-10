import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class ItemTest {





    //>>>>>>>>>>>>>>>>>>>>>>>>>Total Cost<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //TDD Test case for Feature Implementaion of Calculating the total cost of the
    // food item selected from the Restaurant Menu

    @Test
    public void verify_cost_of_selected_items_from_menu() {
        Restaurant restaurant = new Restaurant("New Veg Restaurant","Delhi",
                LocalTime.parse("10:30:00"),LocalTime.parse("20:00:00"));
        restaurant.addToMenu("Idli Vada",50);
        restaurant.addToMenu("Paav Bhaji",100);
        restaurant.addToMenu("Dosa",100);
        restaurant.addToMenu("Rice",50);
        restaurant.addToMenu("Roti",10);
        restaurant.addToMenu("Paneer Butter Masala",60);

        Item item = new Item();
        Item item1 = new Item("Idli Vada",50);
        Item item2 = new Item("Paav Bhaji",100);
        Item item3 = new Item("Dosa",100);
        Item item4 = new Item("Rice",50);

        item.addItems(item1);
        item.addItems(item2);
        item.addItems(item3);
        item.addItems(item4);

        Assertions.assertEquals(300,item.getSelectedItemsTotalCost());

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<Total Cost>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
