package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Cook;
import kts.restaurant_application.repositories.CookRepository;
import kts.restaurant_application.services.CookService;
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

import static kts.restaurant_application.constants.CookConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CookServiceUnitTest {

    @Autowired
    private CookService CookService;

    @MockBean
    private CookRepository CookRepository;

    @Test
    public void testFindAll() {
        List<Cook> Cooks = new ArrayList<>();

        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        Cook Cook2 = new Cook(DB_COOK_FIRSTNAME_UNIT1, DB_COOK_LASTNAME_UNIT1, DB_COOK_USERNAME_UNIT1, DB_COOK_PASSWORD_UNIT1, DB_COOK_DATE_OF_BIRTH_UNIT1, DB_COOK_SALARY_UNIT1, DB_COOK_IS_DELETED_UNIT1);
        Cook Cook3 = new Cook(DB_COOK_FIRSTNAME_UNIT2, DB_COOK_LASTNAME_UNIT2, DB_COOK_USERNAME_UNIT2, DB_COOK_PASSWORD_UNIT2, DB_COOK_DATE_OF_BIRTH_UNIT2, DB_COOK_SALARY_UNIT2, DB_COOK_IS_DELETED_UNIT2);
        Cooks.add(Cook1);
        Cooks.add(Cook2);
        Cooks.add(Cook3);

        given(CookRepository.findAll()).willReturn(Cooks);

        Iterable<Cook> found = CookService.findAll();

        int count = 0;
        for(Cook u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_COOK_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(CookRepository.findById(DB_WRONG_COOK_ID))
                .willThrow(ResponseStatusException.class);


        CookService.findOne(DB_WRONG_COOK_ID);
    }

    @Test
    public void testFindOne() {
        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        Cook1.setId(DB_COOK_ID);

        Mockito.when(CookRepository.findById(DB_COOK_ID))
                .thenReturn(java.util.Optional.of(Cook1));

        Cook found = CookService.findOne(DB_COOK_ID);
        assertEquals(DB_COOK_ID, found.getId());
    }

    @Test
    public void testSave(){
        Cook Cook1 = new Cook(NEW_COOK_FIRSTNAME, NEW_COOK_LASTNAME, NEW_COOK_USERNAME,
                NEW_COOK_PASSWORD, NEW_COOK_DATE_OF_BIRTH, NEW_COOK_SALARY, NEW_COOK_IS_DELETED);

        given(CookRepository.save(Cook1)).willReturn(Cook1);

        Cook created = CookService.save(Cook1);

        assertEquals(NEW_COOK_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        Cook1.setId(DB_COOK_ID);

        Mockito.when(CookRepository.findById(DB_COOK_ID)).thenThrow(ResponseStatusException.class);

        Cook Cook = CookService.delete(DB_COOK_ID);
    }

    @Test
    public void testDelete1(){
        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        Cook1.setId(DB_COOK_ID);

        Mockito.when(CookRepository.findById(DB_COOK_ID)).thenReturn(Optional.of(Cook1));

        Cook deletedCook = Cook1;
        deletedCook.setIsDeleted(true);

        Mockito.when(CookRepository.save(Cook1)).thenReturn(deletedCook);

        Cook Cook = CookService.delete(DB_COOK_ID);

        assertEquals(true, Cook.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED_UNIT);
        Cook1.setId(DB_COOK_ID);

        given(CookRepository.findById(DB_COOK_ID)).willReturn(java.util.Optional.of(Cook1));

        Cook deletedCook = Cook1;
        deletedCook.setIsDeleted(true);

        Mockito.when(CookRepository.save(Cook1)).thenReturn(deletedCook);

        Cook tested_COOK = CookService.delete(Cook1);
        assertEquals(true, tested_COOK.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Cook Cook1 = new Cook(DB_COOK_FIRSTNAME, DB_COOK_LASTNAME, DB_COOK_USERNAME, DB_COOK_PASSWORD, DB_COOK_DATE_OF_BIRTH, DB_COOK_SALARY, DB_COOK_IS_DELETED);
        Cook1.setId(DB_WRONG_COOK_ID);

        Mockito.when(CookRepository.findById(DB_WRONG_COOK_ID)).thenThrow(ResponseStatusException.class);

        Cook tested_COOK = CookService.delete(Cook1);
    }
}
