package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.User;
import kts.restaurant_application.repositories.UserRepository;
import kts.restaurant_application.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kts.restaurant_application.constants.UserConstants.*;
import static kts.restaurant_application.constants.UserConstants.DB_USER_IS_DELETED;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> users = new ArrayList<>();

        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        User user2 = new User(DB_USER_FIRSTNAME_UNIT1, DB_USER_LASTNAME_UNIT1, DB_USER_USERNAME_UNIT1, DB_USER_PASSWORD_UNIT1, DB_USER_DATE_OF_BIRTH_UNIT1, DB_USER_SALARY_UNIT1, DB_USER_IS_DELETED_UNIT1);
        User user3 = new User(DB_USER_FIRSTNAME_UNIT2, DB_USER_LASTNAME_UNIT2, DB_USER_USERNAME_UNIT2, DB_USER_PASSWORD_UNIT2, DB_USER_DATE_OF_BIRTH_UNIT2, DB_USER_SALARY_UNIT2, DB_USER_IS_DELETED_UNIT2);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        given(userRepository.findAll()).willReturn(users);

        Iterable<User> found = userService.findAll();

        int count = 0;
        for(User u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_USERS_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(userRepository.findById(DB_WRONG_USER_ID))
                .willThrow(ResponseStatusException.class);


        userService.findOne(DB_WRONG_USER_ID);
    }

    @Test
    public void testFindOne() {
        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        user1.setId(DB_USER_ID);

        Mockito.when(userRepository.findById(DB_USER_ID))
                .thenReturn(java.util.Optional.of(user1));

        User found = userService.findOne(DB_USER_ID);
        assertEquals(DB_USER_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        User user = new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED);

        given(userRepository.save(user)).willReturn(user);

        User created = userService.save(user);

        assertEquals(NEW_USER_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException() throws Exception {
        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        user1.setId(DB_USER_ID);

        Mockito.when(userRepository.findById(DB_USER_ID)).thenThrow(ResponseStatusException.class);

        User user = userService.delete(DB_USER_ID);
    }

    @Test
    public void testDelete1() throws Exception {
        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        user1.setId(DB_USER_ID);

        Mockito.when(userRepository.findById(DB_USER_ID)).thenReturn(Optional.of(user1));

        User deletedUser = user1;
        deletedUser.setIsDeleted(true);

        Mockito.when(userRepository.save(user1)).thenReturn(deletedUser);

        User user = userService.delete(DB_USER_ID);

        assertEquals(true, user.getIsDeleted()); //userService.delete(DB_USER_ID).getIsDeleted());
    }



    @Test
    public void testDelete2() throws Exception {
        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED_UNIT);
        user1.setId(DB_USER_ID);

        given(userRepository.findById(DB_USER_ID)).willReturn(java.util.Optional.of(user1));

        User deletedUser = user1;
        deletedUser.setIsDeleted(true);

        Mockito.when(userRepository.save(user1)).thenReturn(deletedUser);

        User tested_user = userService.delete(user1);
        assertEquals(true, tested_user.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException() throws Exception {
        User user1 = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, DB_USER_DATE_OF_BIRTH, DB_USER_SALARY, DB_USER_IS_DELETED);
        user1.setId(DB_WRONG_USER_ID);

        Mockito.when(userRepository.findById(DB_WRONG_USER_ID)).thenThrow(ResponseStatusException.class);

        User tested_user = userService.delete(user1);
    }
}
