//import org.graalvm.compiler.debug.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

    /*    LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("01:00:00");
        Restaurant restaurant = Mockito.mock(Restaurant.class);
        //Mockito.when(restaurant.getCurrentTime()).thenReturn(LocalTime.parse("11:00:00"));
        Mockito.when(restaurant.isRestaurantOpen()).thenReturn(true);
        //Mockito.when(restaurant.isRestaurantOpen()).thenReturn(currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime));

        restaurant.openingTime = openingTime;
        restaurant.closingTime = closingTime;

        boolean restaurantOpen = restaurant.isRestaurantOpen();

        assertThat(restaurantOpen, is(equalTo(true)));*/

        restaurant = new Restaurant("New Veg Resturant","UK",LocalTime.parse("10:30:00"),LocalTime.parse("18:30:00"));
        Restaurant restaurantMock = Mockito.spy(restaurant);
        LocalTime checkCurrentTime = LocalTime.parse("11:30:00");
        Mockito.when(restaurantMock.getCurrentTime()).thenReturn(checkCurrentTime);
        boolean check = restaurantMock.isRestaurantOpen();

        assertTrue(check);


    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        restaurant = new Restaurant("New Veg Resturant","UK",LocalTime.parse("10:30:00"),LocalTime.parse("18:30:00"));
        Restaurant restaurantMock = Mockito.spy(restaurant);
        LocalTime checkCurrentTime = LocalTime.parse("19:30:00");
        Mockito.when(restaurantMock.getCurrentTime()).thenReturn(checkCurrentTime);
        boolean check = restaurantMock.isRestaurantOpen();

        assertFalse(check);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}