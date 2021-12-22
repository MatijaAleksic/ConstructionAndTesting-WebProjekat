package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Drink;
import kts.restaurant_application.model.Item;
import kts.restaurant_application.services.DrinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static kts.restaurant_application.constants.DrinkConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class DrinkServiceIntegrationTest {

    @Autowired
    private DrinkService drinkService;

    @Test
    public void testFindAll() {
        Iterable<Drink> found = drinkService.findAll();

        int count = 0;
        for(Drink u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_DRINKS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        drinkService.findOne(DB_WRONG_DRINK_ID);
    }

    @Test
    public void testFindOne() {
        Drink found = drinkService.findOne(DB_DRINK_ID);
        assertEquals(DB_DRINK_ID, found.getId());
    }

    @Test
    public void testSave(){

        Drink item = new Drink(DB_NEW_DRINK_PRICE, DB_NEW_DRINK_PRIPRITY, DB_NEW_DRINK_SUBCATEGORY, DB_NEW_DRINK_DESCRIPTION, DB_NEW_DRINK_IS_DELETED, DB_NEW_DRINK_NAME);

        Drink created = drinkService.save(item);

        assertEquals(DB_NEW_DRINK_NAME, created.getName());
    }

    @Test
    public void testDelete1(){
        Drink item = drinkService.delete(DB_DRINK_ID);
        assertEquals(true, item.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Drink item = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        item.setId(DB_DRINK_ID);

        Item tested_DRINK = drinkService.delete(item);
        assertEquals(true, tested_DRINK.getIsDeleted());
    }
}
