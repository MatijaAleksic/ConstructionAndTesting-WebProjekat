package kts.restaurant_application.repositories;

import kts.restaurant_application.model.User;
import kts.restaurant_application.model.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static kts.restaurant_application.constants.UserConstants.DB_USER_USERNAME1;
import static kts.restaurant_application.constants.UserConstants.WRONG_USER_USERNAME;
import static kts.restaurant_application.constants.WaiterConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class WaiterRepositoryTest {

    @Autowired
    private WaiterRepository waiterRepository;

    @Test
    public void testFindWaiterByUsername() throws ParseException {

        Optional<Waiter> found = waiterRepository.findByUsername(DB_WAITER_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindUserByWrongUsername() throws ParseException {

        Optional<Waiter> found = waiterRepository.findByUsername(WRONG_WAITER_USERNAME);

        assertFalse(found.isPresent());
    }
}
