package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.services.WaiterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.WaiterConstants.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class WaiterServiceIntegrationTest {

    @Autowired
    private WaiterService WaiterService;

    @Test
    public void testFindAll() {
        Iterable<Waiter> found = WaiterService.findAll();

        int count = 0;
        for(Waiter u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_WAITERS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        WaiterService.findOne(DB_WRONG_WAITER_ID);
    }

    @Test
    public void testFindOne() {
        Waiter found = WaiterService.findOne(DB_WAITER_ID);
        assertEquals(DB_WAITER_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        Waiter waiter = new Waiter(NEW_WAITER_FIRSTNAME, NEW_WAITER_LASTNAME, NEW_WAITER_USERNAME,
                NEW_WAITER_PASSWORD, NEW_WAITER_DATE_OF_BIRTH, NEW_WAITER_SALARY, NEW_WAITER_IS_DELETED);

        Waiter created = WaiterService.save(waiter);

        assertEquals(NEW_WAITER_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1() throws Exception {
        Waiter waiter = WaiterService.delete(DB_WAITER_ID);
        assertEquals(true, waiter.getIsDeleted());
    }

    @Test
    public void testDelete2() throws Exception {
        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Waiter tested_WAITER = WaiterService.delete(waiter);
        assertEquals(true, tested_WAITER.getIsDeleted());
    }
}

