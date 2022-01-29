package kts.restaurant_application.repositories;

import kts.restaurant_application.model.MainCook;
import kts.restaurant_application.model.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;


import static kts.restaurant_application.constants.ManagerConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void testFindManagerByUsername() throws ParseException {

        Optional<Manager> found = managerRepository.findByUsername(DB_MANAGER_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindManagerByWrongUsername() throws ParseException {

        Optional<Manager> found = managerRepository.findByUsername(WRONG_MANAGER_USERNAME);

        assertFalse(found.isPresent());
    }
}
