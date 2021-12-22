package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Drink;
import kts.restaurant_application.repositories.DrinkRepository;
import kts.restaurant_application.services.DrinkService;
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

import static kts.restaurant_application.constants.DrinkConstants.*;
import static kts.restaurant_application.constants.DrinkConstants.DB_WRONG_DRINK_ID;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class DrinkServiceUnitTest {

    @Autowired
    private DrinkService DrinkService;

    @MockBean
    private DrinkRepository DrinkRepository;

    @Test
    public void testFindAll() {
        List<Drink> Drinks = new ArrayList<>();

        Drink Drink = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink Drink2 = new Drink(DB_DRINK_PRICE_UNIT1, DB_DRINK_PRIPRITY_UNIT1, DB_DRINK_SUBCATEGORY_UNIT1, DB_DRINK_DESCRIPTION_UNIT1, DB_DRINK_IS_DELETED_UNIT1, DB_DRINK_NAME_UNIT1);
        Drink Drink3 = new Drink(DB_DRINK_PRICE_UNIT2, DB_DRINK_PRIPRITY_UNIT2, DB_DRINK_SUBCATEGORY_UNIT2, DB_DRINK_DESCRIPTION_UNIT2, DB_DRINK_IS_DELETED_UNIT2, DB_DRINK_NAME_UNIT2);
        Drinks.add(Drink);
        Drinks.add(Drink2);
        Drinks.add(Drink3);

        given(DrinkRepository.findAll()).willReturn(Drinks);

        Iterable<Drink> found = DrinkService.findAll();

        int count = 0;
        for(Drink u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_DRINK_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(DrinkRepository.findById(DB_WRONG_DRINK_ID))
                .willThrow(ResponseStatusException.class);


        DrinkService.findOne(DB_WRONG_DRINK_ID);
    }

    @Test
    public void testFindOne() {
        Drink Drink1 = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink1.setId(DB_DRINK_ID);

        Mockito.when(DrinkRepository.findById(DB_DRINK_ID))
                .thenReturn(java.util.Optional.of(Drink1));

        Drink found = DrinkService.findOne(DB_DRINK_ID);
        assertEquals(DB_DRINK_ID, found.getId());
    }

    @Test
    public void testSave(){
        Drink Drink1 = new Drink(DB_NEW_DRINK_PRICE, DB_NEW_DRINK_PRIPRITY, DB_NEW_DRINK_SUBCATEGORY, DB_NEW_DRINK_DESCRIPTION, DB_NEW_DRINK_IS_DELETED, DB_NEW_DRINK_NAME);

        given(DrinkRepository.save(Drink1)).willReturn(Drink1);

        Drink created = DrinkService.save(Drink1);

        assertEquals(DB_NEW_DRINK_NAME, created.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Drink Drink1 = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink1.setId(DB_DRINK_ID);

        Mockito.when(DrinkRepository.findById(DB_DRINK_ID)).thenThrow(ResponseStatusException.class);

        Drink Drink = DrinkService.delete(DB_DRINK_ID);
    }

    @Test
    public void testDelete1(){
        Drink Drink1 = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink1.setId(DB_DRINK_ID);

        Mockito.when(DrinkRepository.findById(DB_DRINK_ID)).thenReturn(Optional.of(Drink1));

        Drink deletedDrink = Drink1;
        deletedDrink.setIsDeleted(true);

        Mockito.when(DrinkRepository.save(Drink1)).thenReturn(deletedDrink);

        Drink Drink = DrinkService.delete(DB_DRINK_ID);

        assertEquals(true, Drink.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Drink Drink1 = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink1.setId(DB_DRINK_ID);

        given(DrinkRepository.findById(DB_DRINK_ID)).willReturn(java.util.Optional.of(Drink1));

        Drink deletedDrink = Drink1;
        deletedDrink.setIsDeleted(true);

        Mockito.when(DrinkRepository.save(Drink1)).thenReturn(deletedDrink);

        Drink tested_DRINK = DrinkService.delete(Drink1);
        assertEquals(true, tested_DRINK.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Drink Drink1 = new Drink(DB_DRINK_PRICE, DB_DRINK_PRIPRITY, DB_DRINK_SUBCATEGORY, DB_DRINK_DESCRIPTION, DB_DRINK_IS_DELETED, DB_DRINK_NAME);
        Drink1.setId(DB_WRONG_DRINK_ID);

        Mockito.when(DrinkRepository.findById(DB_WRONG_DRINK_ID)).thenThrow(ResponseStatusException.class);

        Drink tested_DRINK = DrinkService.delete(Drink1);
    }
}
