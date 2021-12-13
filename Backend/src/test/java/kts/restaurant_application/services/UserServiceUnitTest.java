package kts.restaurant_application.services;

import kts.restaurant_application.model.User;
import kts.restaurant_application.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static kts.restaurant_application.constants.UserConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    //@MockBean
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);;

    @BeforeAll
    public void setup() {
        List<User> users = new ArrayList<>();
        users.add(new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED));


        // Definisanje ponasanja test dvojnika userRepository za
        // findAll metodu
        given(userRepository.findAll()).willReturn(users);


        User User = new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED);
        User savedUser = new User(NEW_USER_FIRSTNAME, NEW_USER_LASTNAME, NEW_USER_USERNAME,
                NEW_USER_PASSWORD, NEW_USER_DATE_OF_BIRTH, NEW_USER_SALARY, NEW_USER_IS_DELETED);
        savedUser.setId(DB_USER_ID);

        given(userRepository.findById(DB_USER_ID))
                .willReturn(java.util.Optional.of(savedUser));

        //given(userRepository.findByName(NEW_CATEGORY)).willReturn(null);

        //User UserFound = new User(DB_CATEGORY_ID, DB_CATEGORY);

        //given(userRepository.findByName(DB_CATEGORY)).willReturn(UserFound);

        //given(userRepository.findByNameAndIdNot(NEW_CATEGORY, CATEGORY_ID)).willReturn(null);

        given(userRepository.save(User)).willReturn(savedUser);
        doNothing().when(userRepository).delete(savedUser);
    }


    @Test
    public void testDelete() {

    }

    @Test
    public void testDelete2() {

    }

    @Test
    public void testFindAll() {
        Iterable<User> found = userService.findAll();

        int count = 0;
        for(User u : found){
            count += 1;
        }

        System.out.println(count);

        verify(userRepository, times(1)).findAll();
        assertEquals(FIND_ALL_NUMBER_OF_ITEMS, count);
    }

    @Test
    public void testFindOne() {
        User found = userService.findOne(DB_USER_ID);

        verify(userRepository, times(1)).findById(DB_USER_ID);
        assertEquals(DB_USER_ID, found.getId());
    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }
}
