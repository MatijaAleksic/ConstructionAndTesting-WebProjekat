package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Food;
import kts.restaurant_application.model.Item;
import kts.restaurant_application.services.FoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static kts.restaurant_application.constants.FoodConstants.*;
import static kts.restaurant_application.constants.FoodConstants.DB_FOOD_ID;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class FoodServiceIntegrationTest {

    @Autowired
    private FoodService foodService;

    @Test
    public void testFindAll() {
        Iterable<Food> found = foodService.findAll();

        int count = 0;
        for(Food u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_FOODS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        foodService.findOne(DB_WRONG_FOOD_ID);
    }

    @Test
    public void testFindOne() {
        Food found = foodService.findOne(DB_FOOD_ID);
        assertEquals(DB_FOOD_ID, found.getId());
    }

    @Test
    public void testSave(){

        Food item = new Food(DB_NEW_FOOD_PRICE, DB_NEW_FOOD_PRIPRITY, DB_NEW_FOOD_SUBCATEGORY, DB_NEW_FOOD_DESCRIPTION, DB_NEW_FOOD_IS_DELETED, DB_NEW_FOOD_NAME);

        Food created = foodService.save(item);

        assertEquals(DB_NEW_FOOD_NAME, created.getName());
    }

    @Test
    public void testDelete1(){
        Food item = foodService.delete(DB_FOOD_ID);
        assertEquals(true, item.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Food item = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        item.setId(DB_FOOD_ID);

        Item tested_food = foodService.delete(item);
        assertEquals(true, tested_food.getIsDeleted());
    }
}
