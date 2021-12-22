package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.repositories.WaiterRepository;
import kts.restaurant_application.services.WaiterService;
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

import static kts.restaurant_application.constants.WaiterConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class WaiterServiceUnitTest {

    @Autowired
    private WaiterService WaiterService;

    @MockBean
    private WaiterRepository WaiterRepository;

    @Test
    public void testFindAll() {
        List<Waiter> Waiters = new ArrayList<>();

        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        Waiter Waiter2 = new Waiter(DB_WAITER_FIRSTNAME_UNIT1, DB_WAITER_LASTNAME_UNIT1, DB_WAITER_USERNAME_UNIT1, DB_WAITER_PASSWORD_UNIT1, DB_WAITER_DATE_OF_BIRTH_UNIT1, DB_WAITER_SALARY_UNIT1, DB_WAITER_IS_DELETED_UNIT1);
        Waiter Waiter3 = new Waiter(DB_WAITER_FIRSTNAME_UNIT2, DB_WAITER_LASTNAME_UNIT2, DB_WAITER_USERNAME_UNIT2, DB_WAITER_PASSWORD_UNIT2, DB_WAITER_DATE_OF_BIRTH_UNIT2, DB_WAITER_SALARY_UNIT2, DB_WAITER_IS_DELETED_UNIT2);
        Waiters.add(Waiter1);
        Waiters.add(Waiter2);
        Waiters.add(Waiter3);

        given(WaiterRepository.findAll()).willReturn(Waiters);

        Iterable<Waiter> found = WaiterService.findAll();

        int count = 0;
        for(Waiter u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_WAITER_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(WaiterRepository.findById(DB_WRONG_WAITER_ID))
                .willThrow(ResponseStatusException.class);


        WaiterService.findOne(DB_WRONG_WAITER_ID);
    }

    @Test
    public void testFindOne() {
        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        Waiter1.setId(DB_WAITER_ID);

        Mockito.when(WaiterRepository.findById(DB_WAITER_ID))
                .thenReturn(java.util.Optional.of(Waiter1));

        Waiter found = WaiterService.findOne(DB_WAITER_ID);
        assertEquals(DB_WAITER_ID, found.getId());
    }

    @Test
    public void testSave(){
        Waiter Waiter1 = new Waiter(NEW_WAITER_FIRSTNAME, NEW_WAITER_LASTNAME, NEW_WAITER_USERNAME,
                NEW_WAITER_PASSWORD, NEW_WAITER_DATE_OF_BIRTH, NEW_WAITER_SALARY, NEW_WAITER_IS_DELETED);

        given(WaiterRepository.save(Waiter1)).willReturn(Waiter1);

        Waiter created = WaiterService.save(Waiter1);

        assertEquals(NEW_WAITER_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        Waiter1.setId(DB_WAITER_ID);

        Mockito.when(WaiterRepository.findById(DB_WAITER_ID)).thenThrow(ResponseStatusException.class);

        Waiter Waiter = WaiterService.delete(DB_WAITER_ID);
    }

    @Test
    public void testDelete1(){
        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        Waiter1.setId(DB_WAITER_ID);

        Mockito.when(WaiterRepository.findById(DB_WAITER_ID)).thenReturn(Optional.of(Waiter1));

        Waiter deletedWaiter = Waiter1;
        deletedWaiter.setIsDeleted(true);

        Mockito.when(WaiterRepository.save(Waiter1)).thenReturn(deletedWaiter);

        Waiter Waiter = WaiterService.delete(DB_WAITER_ID);

        assertEquals(true, Waiter.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED_UNIT);
        Waiter1.setId(DB_WAITER_ID);

        given(WaiterRepository.findById(DB_WAITER_ID)).willReturn(java.util.Optional.of(Waiter1));

        Waiter deletedWaiter = Waiter1;
        deletedWaiter.setIsDeleted(true);

        Mockito.when(WaiterRepository.save(Waiter1)).thenReturn(deletedWaiter);

        Waiter tested_WAITER = WaiterService.delete(Waiter1);
        assertEquals(true, tested_WAITER.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Waiter Waiter1 = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        Waiter1.setId(DB_WRONG_WAITER_ID);

        Mockito.when(WaiterRepository.findById(DB_WRONG_WAITER_ID)).thenThrow(ResponseStatusException.class);

        Waiter tested_WAITER = WaiterService.delete(Waiter1);
    }
}
