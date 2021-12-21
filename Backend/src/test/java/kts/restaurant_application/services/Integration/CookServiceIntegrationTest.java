package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Cook;
import kts.restaurant_application.services.CookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.CookConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CookServiceIntegrationTest {

    @Autowired
    private CookService cookService;

    @Test
    public void testFindAll() {
        Iterable<Cook> found = cookService.findAll();

        int count = 0;
        for(Cook u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_COOKS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        cookService.findOne(DB_WRONG_COOK_ID);
    }

    @Test
    public void testFindOne() {
        Cook found = cookService.findOne(DB_COOK_ID);
        assertEquals(DB_COOK_ID, found.getId());
    }

    @Test
    public void testSave(){
        Cook cook = new Cook(NEW_COOK_FIRSTNAME, NEW_COOK_LASTNAME, NEW_COOK_USERNAME,
                NEW_COOK_PASSWORD, NEW_COOK_DATE_OF_BIRTH, NEW_COOK_SALARY, NEW_COOK_IS_DELETED);

        Cook created = cookService.save(cook);

        assertEquals(NEW_COOK_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1(){
        Cook cook = cookService.delete(DB_COOK_ID);
        assertEquals(true, cook.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Cook cook = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        cook.setId(DB_COOK_ID);

        Cook tested_cook = cookService.delete(cook);
        assertEquals(true, tested_cook.getIsDeleted());
    }
}
