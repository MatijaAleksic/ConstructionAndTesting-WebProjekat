package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.MainCook;
import kts.restaurant_application.services.MainCookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static kts.restaurant_application.constants.MainCookConstants.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class MainCookServiceIntegrationTest {

    @Autowired
    private MainCookService mainCookService;

    @Test
    public void testFindAll() {
        Iterable<MainCook> found = mainCookService.findAll();

        int count = 0;
        for(MainCook u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_MAIN_COOKS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        mainCookService.findOne(DB_WRONG_MAIN_COOK_ID);
    }

    @Test
    public void testFindOne() {
        MainCook found = mainCookService.findOne(DB_MAIN_COOK_ID);
        assertEquals(DB_MAIN_COOK_ID, found.getId());
    }

    @Test
    public void testSave(){
        MainCook mainCook = new MainCook(NEW_MAIN_COOK_FIRSTNAME, NEW_MAIN_COOK_LASTNAME, NEW_MAIN_COOK_USERNAME,
                NEW_MAIN_COOK_PASSWORD, NEW_MAIN_COOK_DATE_OF_BIRTH, NEW_MAIN_COOK_SALARY, NEW_MAIN_COOK_IS_DELETED);

        MainCook created = mainCookService.save(mainCook);

        assertEquals(NEW_MAIN_COOK_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1() {
        MainCook mainCook = mainCookService.delete(DB_MAIN_COOK_ID);
        assertEquals(true, mainCook.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        MainCook mainCook = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        mainCook.setId(DB_MAIN_COOK_ID);

        MainCook tested_main_cook = mainCookService.delete(mainCook);
        assertEquals(true, tested_main_cook.getIsDeleted());
    }
}
