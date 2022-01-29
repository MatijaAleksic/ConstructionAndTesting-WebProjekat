package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Barman;
import kts.restaurant_application.model.Cook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;


import static kts.restaurant_application.constants.CookConstants.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CookRepositoryTest {

    @Autowired
    private CookRepository cookRepository;

    @Test
    public void testFindAdminByUsername() throws ParseException {

        Optional<Cook> found = cookRepository.findByUsername(DB_COOK_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindAdminByWrongUsername() throws ParseException {

        Optional<Cook> found = cookRepository.findByUsername(WRONG_COOK_USERNAME);

        assertFalse(found.isPresent());
    }
}
