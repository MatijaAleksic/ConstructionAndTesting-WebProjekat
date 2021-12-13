package kts.restaurant_application.services;

import kts.restaurant_application.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static kts.restaurant_application.constants.UserConstants.*;

import java.util.List;

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
    public void testDelete() throws Exception {
        userService.delete(DB_USER_ID_DELETE);

//        User savedUser = new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
//                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED);
//        savedUser.setId(DB_USER_ID_DELETE);
    }
}
