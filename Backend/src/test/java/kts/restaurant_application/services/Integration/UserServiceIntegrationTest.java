package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.MainCook;
import kts.restaurant_application.model.User;
import kts.restaurant_application.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.UserConstants.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        Iterable<User> found = userService.findAll();

        int count = 0;
        for(User u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_USERS, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        userService.findOne(DB_WRONG_USER_ID);
    }

    @Test
    public void testFindOne() {
        User found = userService.findOne(DB_USER_ID);
        assertEquals(DB_USER_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        User user = new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED);

        User created = userService.save(user);

        assertEquals(NEW_USER_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1() throws Exception {
        User user = userService.delete(DB_USER_ID_DELETE);
        assertEquals(true, user.getIsDeleted());
    }

    @Test
    public void testDelete2() throws Exception {
        User user = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        user.setId(2L);

        User tested_user = userService.delete(user);
        assertEquals(true, tested_user.getIsDeleted());
    }
}
