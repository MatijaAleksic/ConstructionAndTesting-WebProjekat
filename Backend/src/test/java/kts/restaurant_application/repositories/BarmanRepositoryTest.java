package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.Barman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static kts.restaurant_application.constants.BarmanConstants.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class BarmanRepositoryTest {

    @Autowired
    private BarmanRepository barmanRepository;

    @Test
    public void testFindBarmanByUsername() throws ParseException {

        Optional<Barman> found = barmanRepository.findByUsername(DB_BARMAN_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindBarmanByWrongUsername() throws ParseException {

        Optional<Barman> found = barmanRepository.findByUsername(WRONG_BARMAN_USERNAME);

        assertFalse(found.isPresent());
    }
}
