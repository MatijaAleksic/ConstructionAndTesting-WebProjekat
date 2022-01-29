package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Authority;
import kts.restaurant_application.model.Barman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static kts.restaurant_application.constants.BarmanConstants.DB_BARMAN_USERNAME1;
import static kts.restaurant_application.constants.BarmanConstants.WRONG_BARMAN_USERNAME;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class AuthorityRepositoryTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Test
    public void testFindAuthorityFindByName() throws ParseException {

        Authority found = authorityRepository.findByName("ROLE_USER");

        assertEquals(found.getName(), "ROLE_USER");
    }

    @Test
    public void testFindAuthorityFindByWrongName() throws ParseException {

        Authority found = authorityRepository.findByName("WRONG");

        assertNull(found);
    }
}
