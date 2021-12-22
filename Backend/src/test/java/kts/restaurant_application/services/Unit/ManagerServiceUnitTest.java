package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.User;
import kts.restaurant_application.repositories.ManagerRepository;
import kts.restaurant_application.repositories.UserRepository;
import kts.restaurant_application.services.ManagerService;
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

import static kts.restaurant_application.constants.ManagerConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ManagerServiceUnitTest {

    @Autowired
    private ManagerService ManagerService;

    @MockBean
    private ManagerRepository ManagerRepository;

    @Test
    public void testFindAll() {
        List<Manager> Managers = new ArrayList<>();

        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        Manager Manager2 = new Manager(DB_MANAGER_FIRSTNAME_UNIT1, DB_MANAGER_LASTNAME_UNIT1, DB_MANAGER_USERNAME_UNIT1, DB_MANAGER_PASSWORD_UNIT1, DB_MANAGER_DATE_OF_BIRTH_UNIT1, DB_MANAGER_SALARY_UNIT1, DB_MANAGER_IS_DELETED_UNIT1);
        Manager Manager3 = new Manager(DB_MANAGER_FIRSTNAME_UNIT2, DB_MANAGER_LASTNAME_UNIT2, DB_MANAGER_USERNAME_UNIT2, DB_MANAGER_PASSWORD_UNIT2, DB_MANAGER_DATE_OF_BIRTH_UNIT2, DB_MANAGER_SALARY_UNIT2, DB_MANAGER_IS_DELETED_UNIT2);
        Managers.add(Manager1);
        Managers.add(Manager2);
        Managers.add(Manager3);

        given(ManagerRepository.findAll()).willReturn(Managers);

        Iterable<Manager> found = ManagerService.findAll();

        int count = 0;
        for(Manager u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_MANAGER_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(ManagerRepository.findById(DB_WRONG_MANAGER_ID))
                .willThrow(ResponseStatusException.class);


        ManagerService.findOne(DB_WRONG_MANAGER_ID);
    }

    @Test
    public void testFindOne() {
        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        Manager1.setId(DB_MANAGER_ID);

        Mockito.when(ManagerRepository.findById(DB_MANAGER_ID))
                .thenReturn(java.util.Optional.of(Manager1));

        Manager found = ManagerService.findOne(DB_MANAGER_ID);
        assertEquals(DB_MANAGER_ID, found.getId());
    }

    @Test
    public void testSave(){
        Manager Manager1 = new Manager(NEW_MANAGER_FIRSTNAME, NEW_MANAGER_LASTNAME, NEW_MANAGER_USERNAME,
                NEW_MANAGER_PASSWORD, NEW_MANAGER_DATE_OF_BIRTH, NEW_MANAGER_SALARY, NEW_MANAGER_IS_DELETED);

        given(ManagerRepository.save(Manager1)).willReturn(Manager1);

        Manager created = ManagerService.save(Manager1);

        assertEquals(NEW_MANAGER_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        Manager1.setId(DB_MANAGER_ID);

        Mockito.when(ManagerRepository.findById(DB_MANAGER_ID)).thenThrow(ResponseStatusException.class);

        Manager Manager = ManagerService.delete(DB_MANAGER_ID);
    }

    @Test
    public void testDelete1(){
        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        Manager1.setId(DB_MANAGER_ID);

        Mockito.when(ManagerRepository.findById(DB_MANAGER_ID)).thenReturn(Optional.of(Manager1));

        Manager deletedManager = Manager1;
        deletedManager.setIsDeleted(true);

        Mockito.when(ManagerRepository.save(Manager1)).thenReturn(deletedManager);

        Manager Manager = ManagerService.delete(DB_MANAGER_ID);

        assertEquals(true, Manager.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED_UNIT);
        Manager1.setId(DB_MANAGER_ID);

        given(ManagerRepository.findById(DB_MANAGER_ID)).willReturn(java.util.Optional.of(Manager1));

        Manager deletedManager = Manager1;
        deletedManager.setIsDeleted(true);

        Mockito.when(ManagerRepository.save(Manager1)).thenReturn(deletedManager);

        Manager tested_MANAGER = ManagerService.delete(Manager1);
        assertEquals(true, tested_MANAGER.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Manager Manager1 = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        Manager1.setId(DB_WRONG_MANAGER_ID);

        Mockito.when(ManagerRepository.findById(DB_WRONG_MANAGER_ID)).thenThrow(ResponseStatusException.class);

        Manager tested_MANAGER = ManagerService.delete(Manager1);
    }
}
