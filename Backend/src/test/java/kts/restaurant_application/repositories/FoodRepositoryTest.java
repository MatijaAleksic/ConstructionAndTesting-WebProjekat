package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Food;
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
public class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void testFindFoodBySubcategory() throws ParseException {

        Collection<Item> found = foodRepository.findAllBySubcategory("subcategory4");

        assertEquals(found.size(), 1);
    }

    @Test
    public void testFindFoodByWrongSubcategory() throws ParseException {

        Collection<Item> found = foodRepository.findAllBySubcategory("WRONG");

        assertEquals(found.size(), 0);
    }
}
