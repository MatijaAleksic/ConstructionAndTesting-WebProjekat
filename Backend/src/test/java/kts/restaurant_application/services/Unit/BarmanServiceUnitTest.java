package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Barman;
import kts.restaurant_application.repositories.BarmanRepository;
import kts.restaurant_application.services.BarmanService;
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

import static kts.restaurant_application.constants.BarmanConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class BarmanServiceUnitTest {

    @Autowired
    private BarmanService BarmanService;

    @MockBean
    private BarmanRepository BarmanRepository;

    @Test
    public void testFindAll() {
        List<Barman> Barmans = new ArrayList<>();

        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        Barman Barman2 = new Barman(DB_BARMAN_FIRSTNAME_UNIT1, DB_BARMAN_LASTNAME_UNIT1, DB_BARMAN_USERNAME_UNIT1, DB_BARMAN_PASSWORD_UNIT1, DB_BARMAN_DATE_OF_BIRTH_UNIT1, DB_BARMAN_SALARY_UNIT1, DB_BARMAN_IS_DELETED_UNIT1);
        Barman Barman3 = new Barman(DB_BARMAN_FIRSTNAME_UNIT2, DB_BARMAN_LASTNAME_UNIT2, DB_BARMAN_USERNAME_UNIT2, DB_BARMAN_PASSWORD_UNIT2, DB_BARMAN_DATE_OF_BIRTH_UNIT2, DB_BARMAN_SALARY_UNIT2, DB_BARMAN_IS_DELETED_UNIT2);
        Barmans.add(Barman1);
        Barmans.add(Barman2);
        Barmans.add(Barman3);

        given(BarmanRepository.findAll()).willReturn(Barmans);

        Iterable<Barman> found = BarmanService.findAll();

        int count = 0;
        for(Barman u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_BARMAN_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(BarmanRepository.findById(DB_WRONG_BARMAN_ID))
                .willThrow(ResponseStatusException.class);


        BarmanService.findOne(DB_WRONG_BARMAN_ID);
    }

    @Test
    public void testFindOne() {
        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        Barman1.setId(DB_BARMAN_ID);

        Mockito.when(BarmanRepository.findById(DB_BARMAN_ID))
                .thenReturn(java.util.Optional.of(Barman1));

        Barman found = BarmanService.findOne(DB_BARMAN_ID);
        assertEquals(DB_BARMAN_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        Barman Barman1 = new Barman(NEW_BARMAN_FIRSTNAME, NEW_BARMAN_LASTNAME, NEW_BARMAN_USERNAME,
                NEW_BARMAN_PASSWORD, NEW_BARMAN_DATE_OF_BIRTH, NEW_BARMAN_SALARY, NEW_BARMAN_IS_DELETED);

        given(BarmanRepository.save(Barman1)).willReturn(Barman1);

        Barman created = BarmanService.save(Barman1);

        assertEquals(NEW_BARMAN_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException() throws Exception {
        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        Barman1.setId(DB_BARMAN_ID);

        Mockito.when(BarmanRepository.findById(DB_BARMAN_ID)).thenThrow(ResponseStatusException.class);

        Barman Barman = BarmanService.delete(DB_BARMAN_ID);
    }

    @Test
    public void testDelete1() throws Exception {
        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        Barman1.setId(DB_BARMAN_ID);

        Mockito.when(BarmanRepository.findById(DB_BARMAN_ID)).thenReturn(Optional.of(Barman1));

        Barman deletedBarman = Barman1;
        deletedBarman.setIsDeleted(true);

        Mockito.when(BarmanRepository.save(Barman1)).thenReturn(deletedBarman);

        Barman Barman = BarmanService.delete(DB_BARMAN_ID);

        assertEquals(true, Barman.getIsDeleted());
    }



    @Test
    public void testDelete2() throws Exception {
        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED_UNIT);
        Barman1.setId(DB_BARMAN_ID);

        given(BarmanRepository.findById(DB_BARMAN_ID)).willReturn(java.util.Optional.of(Barman1));

        Barman deletedBarman = Barman1;
        deletedBarman.setIsDeleted(true);

        Mockito.when(BarmanRepository.save(Barman1)).thenReturn(deletedBarman);

        Barman tested_BARMAN = BarmanService.delete(Barman1);
        assertEquals(true, tested_BARMAN.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException() throws Exception {
        Barman Barman1 = new Barman(DB_BARMAN_FIRSTNAME, DB_BARMAN_LASTNAME, DB_BARMAN_USERNAME, DB_BARMAN_PASSWORD, DB_BARMAN_DATE_OF_BIRTH, DB_BARMAN_SALARY, DB_BARMAN_IS_DELETED);
        Barman1.setId(DB_WRONG_BARMAN_ID);

        Mockito.when(BarmanRepository.findById(DB_WRONG_BARMAN_ID)).thenThrow(ResponseStatusException.class);

        Barman tested_BARMAN = BarmanService.delete(Barman1);
    }
}
