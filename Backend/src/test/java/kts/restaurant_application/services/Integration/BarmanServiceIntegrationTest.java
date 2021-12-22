package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Barman;
import kts.restaurant_application.services.BarmanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.BarmanConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class BarmanServiceIntegrationTest {

    @Autowired
    private BarmanService barmanService;

    @Test
    public void testFindAll() {
        Iterable<Barman> found = barmanService.findAll();

        int count = 0;
        for(Barman b : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_BARMANS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        barmanService.findOne(DB_WRONG_BARMAN_ID);
    }

    @Test
    public void testFindOne() {
        Barman found = barmanService.findOne(DB_BARMAN_ID);
        assertEquals(DB_BARMAN_ID, found.getId());
    }

    @Test
    public void testSave(){
        Barman barman= new Barman(NEW_BARMAN_FIRSTNAME, NEW_BARMAN_LASTNAME, NEW_BARMAN_USERNAME,
                NEW_BARMAN_PASSWORD, NEW_BARMAN_DATE_OF_BIRTH, NEW_BARMAN_SALARY, NEW_BARMAN_IS_DELETED);

        Barman created = barmanService.save(barman);

        assertEquals(NEW_BARMAN_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1(){
        Barman barman= barmanService.delete(DB_BARMAN_ID);
        assertEquals(true, barman.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Barman barman = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        barman.setId(DB_BARMAN_ID);

        Barman tested_barman = barmanService.delete(barman);
        assertEquals(true, tested_barman.getIsDeleted());
    }
}
