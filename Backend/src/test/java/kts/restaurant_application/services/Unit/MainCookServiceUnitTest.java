package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.MainCook;
import kts.restaurant_application.repositories.MainCookRepository;
import kts.restaurant_application.services.MainCookService;
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

import static kts.restaurant_application.constants.MainCookConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class MainCookServiceUnitTest {

    @Autowired
    private MainCookService mainCookService;

    @MockBean
    private MainCookRepository mainCookRepository;

    @Test
    public void testFindAll() {
        List<MainCook> mainCooks = new ArrayList<>();

        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        MainCook mainCook2 = new MainCook(DB_MAIN_COOK_FIRSTNAME_UNIT1, DB_MAIN_COOK_LASTNAME_UNIT1, DB_MAIN_COOK_USERNAME_UNIT1, DB_MAIN_COOK_PASSWORD_UNIT1, DB_MAIN_COOK_DATE_OF_BIRTH_UNIT1, DB_MAIN_COOK_SALARY_UNIT1, DB_MAIN_COOK_IS_DELETED_UNIT1);
        MainCook mainCook3 = new MainCook(DB_MAIN_COOK_FIRSTNAME_UNIT2, DB_MAIN_COOK_LASTNAME_UNIT2, DB_MAIN_COOK_USERNAME_UNIT2, DB_MAIN_COOK_PASSWORD_UNIT2, DB_MAIN_COOK_DATE_OF_BIRTH_UNIT2, DB_MAIN_COOK_SALARY_UNIT2, DB_MAIN_COOK_IS_DELETED_UNIT2);
        mainCooks.add(mainCook1);
        mainCooks.add(mainCook2);
        mainCooks.add(mainCook3);

        given(mainCookRepository.findAll()).willReturn(mainCooks);

        Iterable<MainCook> found = mainCookService.findAll();

        int count = 0;
        for(MainCook u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_MAIN_COOK_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(mainCookRepository.findById(DB_WRONG_MAIN_COOK_ID))
                .willThrow(ResponseStatusException.class);


        mainCookService.findOne(DB_WRONG_MAIN_COOK_ID);
    }

    @Test
    public void testFindOne() {
        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        mainCook1.setId(DB_MAIN_COOK_ID);

        Mockito.when(mainCookRepository.findById(DB_MAIN_COOK_ID))
                .thenReturn(java.util.Optional.of(mainCook1));

        MainCook found = mainCookService.findOne(DB_MAIN_COOK_ID);
        assertEquals(DB_MAIN_COOK_ID, found.getId());
    }

    @Test
    public void testSave(){
        MainCook mainCook1 = new MainCook(NEW_MAIN_COOK_FIRSTNAME, NEW_MAIN_COOK_LASTNAME, NEW_MAIN_COOK_USERNAME,
                NEW_MAIN_COOK_PASSWORD, NEW_MAIN_COOK_DATE_OF_BIRTH, NEW_MAIN_COOK_SALARY, NEW_MAIN_COOK_IS_DELETED);

        given(mainCookRepository.save(mainCook1)).willReturn(mainCook1);

        MainCook created = mainCookService.save(mainCook1);

        assertEquals(NEW_MAIN_COOK_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        mainCook1.setId(DB_MAIN_COOK_ID);

        Mockito.when(mainCookRepository.findById(DB_MAIN_COOK_ID)).thenThrow(ResponseStatusException.class);

        MainCook mainCook = mainCookService.delete(DB_MAIN_COOK_ID);
    }

    @Test
    public void testDelete1(){
        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        mainCook1.setId(DB_MAIN_COOK_ID);

        Mockito.when(mainCookRepository.findById(DB_MAIN_COOK_ID)).thenReturn(Optional.of(mainCook1));

        MainCook deletedMainCook = mainCook1;
        deletedMainCook.setIsDeleted(true);

        Mockito.when(mainCookRepository.save(mainCook1)).thenReturn(deletedMainCook);

        MainCook mainCook = mainCookService.delete(DB_MAIN_COOK_ID);

        assertEquals(true, mainCook.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED_UNIT);
        mainCook1.setId(DB_MAIN_COOK_ID);

        given(mainCookRepository.findById(DB_MAIN_COOK_ID)).willReturn(java.util.Optional.of(mainCook1));

        MainCook deletedMainCook = mainCook1;
        deletedMainCook.setIsDeleted(true);

        Mockito.when(mainCookRepository.save(mainCook1)).thenReturn(deletedMainCook);

        MainCook tested_MAIN_COOK = mainCookService.delete(mainCook1);
        assertEquals(true, tested_MAIN_COOK.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        MainCook mainCook1 = new MainCook(DB_MAIN_COOK_FIRSTNAME, DB_MAIN_COOK_LASTNAME, DB_MAIN_COOK_USERNAME, DB_MAIN_COOK_PASSWORD, DB_MAIN_COOK_DATE_OF_BIRTH, DB_MAIN_COOK_SALARY, DB_MAIN_COOK_IS_DELETED);
        mainCook1.setId(DB_WRONG_MAIN_COOK_ID);

        Mockito.when(mainCookRepository.findById(DB_WRONG_MAIN_COOK_ID)).thenThrow(ResponseStatusException.class);

        MainCook tested_MAIN_COOK = mainCookService.delete(mainCook1);
    }
}
