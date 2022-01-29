package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Staff;
import kts.restaurant_application.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_USERNAME1;
import static kts.restaurant_application.constants.StaffConstants.WRONG_STAFF_USERNAME;
import static kts.restaurant_application.constants.UserConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByUsername() throws ParseException {

        Optional<User> found = userRepository.findByUsername(DB_USER_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindUserByWrongUsername() throws ParseException {

        Optional<User> found = userRepository.findByUsername(WRONG_USER_USERNAME);

        assertFalse(found.isPresent());
    }
}
