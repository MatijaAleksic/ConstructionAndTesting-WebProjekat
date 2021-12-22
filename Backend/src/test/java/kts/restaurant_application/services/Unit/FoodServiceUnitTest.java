package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Food;
import kts.restaurant_application.repositories.FoodRepository;
import kts.restaurant_application.services.FoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kts.restaurant_application.constants.FoodConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class FoodServiceUnitTest {

    @Autowired
    private FoodService FoodService;

    @MockBean
    private FoodRepository FoodRepository;

    @Test
    public void testFindAll() {
        List<Food> Foods = new ArrayList<>();

        Food Food = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food Food2 = new Food(DB_FOOD_PRICE_UNIT1, DB_FOOD_PRIPRITY_UNIT1, DB_FOOD_SUBCATEGORY_UNIT1, DB_FOOD_DESCRIPTION_UNIT1, DB_FOOD_IS_DELETED_UNIT1, DB_FOOD_NAME_UNIT1);
        Food Food3 = new Food(DB_FOOD_PRICE_UNIT2, DB_FOOD_PRIPRITY_UNIT2, DB_FOOD_SUBCATEGORY_UNIT2, DB_FOOD_DESCRIPTION_UNIT2, DB_FOOD_IS_DELETED_UNIT2, DB_FOOD_NAME_UNIT2);
        Foods.add(Food);
        Foods.add(Food2);
        Foods.add(Food3);

        given(FoodRepository.findAll()).willReturn(Foods);

        Iterable<Food> found = FoodService.findAll();

        int count = 0;
        for(Food u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_FOOD_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(FoodRepository.findById(DB_WRONG_FOOD_ID))
                .willThrow(ResponseStatusException.class);


        FoodService.findOne(DB_WRONG_FOOD_ID);
    }

    @Test
    public void testFindOne() {
        Food Food1 = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food1.setId(DB_FOOD_ID);

        Mockito.when(FoodRepository.findById(DB_FOOD_ID))
                .thenReturn(java.util.Optional.of(Food1));

        Food found = FoodService.findOne(DB_FOOD_ID);
        assertEquals(DB_FOOD_ID, found.getId());
    }

    @Test
    public void testSave(){
        Food Food1 = new Food(DB_NEW_FOOD_PRICE, DB_NEW_FOOD_PRIPRITY, DB_NEW_FOOD_SUBCATEGORY, DB_NEW_FOOD_DESCRIPTION, DB_NEW_FOOD_IS_DELETED, DB_NEW_FOOD_NAME);

        given(FoodRepository.save(Food1)).willReturn(Food1);

        Food created = FoodService.save(Food1);

        assertEquals(DB_NEW_FOOD_NAME, created.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Food Food1 = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food1.setId(DB_FOOD_ID);

        Mockito.when(FoodRepository.findById(DB_FOOD_ID)).thenThrow(ResponseStatusException.class);

        Food Food = FoodService.delete(DB_FOOD_ID);
    }

    @Test
    public void testDelete1(){
        Food Food1 = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food1.setId(DB_FOOD_ID);

        Mockito.when(FoodRepository.findById(DB_FOOD_ID)).thenReturn(Optional.of(Food1));

        Food deletedFood = Food1;
        deletedFood.setIsDeleted(true);

        Mockito.when(FoodRepository.save(Food1)).thenReturn(deletedFood);

        Food Food = FoodService.delete(DB_FOOD_ID);

        assertEquals(true, Food.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Food Food1 = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food1.setId(DB_FOOD_ID);

        given(FoodRepository.findById(DB_FOOD_ID)).willReturn(java.util.Optional.of(Food1));

        Food deletedFood = Food1;
        deletedFood.setIsDeleted(true);

        Mockito.when(FoodRepository.save(Food1)).thenReturn(deletedFood);

        Food tested_FOOD = FoodService.delete(Food1);
        assertEquals(true, tested_FOOD.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Food Food1 = new Food(DB_FOOD_PRICE, DB_FOOD_PRIPRITY, DB_FOOD_SUBCATEGORY, DB_FOOD_DESCRIPTION, DB_FOOD_IS_DELETED, DB_FOOD_NAME);
        Food1.setId(DB_WRONG_FOOD_ID);

        Mockito.when(FoodRepository.findById(DB_WRONG_FOOD_ID)).thenThrow(ResponseStatusException.class);

        Food tested_FOOD = FoodService.delete(Food1);
    }
}
