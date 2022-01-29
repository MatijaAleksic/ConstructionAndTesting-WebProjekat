package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Authority;
import kts.restaurant_application.model.Drink;
import kts.restaurant_application.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class DrinkRepositoryTest {

    @Autowired
    private DrinkRepository drinkRepository;

    @Test
    public void testFindDrinkBySubcategory() throws ParseException {

        Collection<Item> found = drinkRepository.findAllBySubcategory("subcategory1");

        assertEquals(found.size(), 1);
    }

    @Test
    public void testFindDrinkByWrongSubcategory() throws ParseException {

        Collection<Item> found = drinkRepository.findAllBySubcategory("WRONG");

        assertEquals(found.size(), 0);
    }
}
