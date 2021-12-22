package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Staff;
import kts.restaurant_application.repositories.StaffRepository;
import kts.restaurant_application.services.StaffService;
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

import static kts.restaurant_application.constants.StaffConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class StaffServiceUnitTest {

    @Autowired
    private StaffService StaffService;

    @MockBean
    private StaffRepository StaffRepository;

    @Test
    public void testFindAll() {
        List<Staff> Staffs = new ArrayList<>();

        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        Staff Staff2 = new Staff(DB_STAFF_FIRSTNAME_UNIT1, DB_STAFF_LASTNAME_UNIT1, DB_STAFF_USERNAME_UNIT1, DB_STAFF_PASSWORD_UNIT1, DB_STAFF_DATE_OF_BIRTH_UNIT1, DB_STAFF_SALARY_UNIT1, DB_STAFF_IS_DELETED_UNIT1);
        Staff Staff3 = new Staff(DB_STAFF_FIRSTNAME_UNIT2, DB_STAFF_LASTNAME_UNIT2, DB_STAFF_USERNAME_UNIT2, DB_STAFF_PASSWORD_UNIT2, DB_STAFF_DATE_OF_BIRTH_UNIT2, DB_STAFF_SALARY_UNIT2, DB_STAFF_IS_DELETED_UNIT2);
        Staffs.add(Staff1);
        Staffs.add(Staff2);
        Staffs.add(Staff3);

        given(StaffRepository.findAll()).willReturn(Staffs);

        Iterable<Staff> found = StaffService.findAll();

        int count = 0;
        for(Staff u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_STAFF_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(StaffRepository.findById(DB_WRONG_STAFF_ID))
                .willThrow(ResponseStatusException.class);


        StaffService.findOne(DB_WRONG_STAFF_ID);
    }

    @Test
    public void testFindOne() {
        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        Staff1.setId(DB_STAFF_ID);

        Mockito.when(StaffRepository.findById(DB_STAFF_ID))
                .thenReturn(java.util.Optional.of(Staff1));

        Staff found = StaffService.findOne(DB_STAFF_ID);
        assertEquals(DB_STAFF_ID, found.getId());
    }

    @Test
    public void testSave(){
        Staff Staff1 = new Staff(NEW_STAFF_FIRSTNAME, NEW_STAFF_LASTNAME, NEW_STAFF_USERNAME,
                NEW_STAFF_PASSWORD, NEW_STAFF_DATE_OF_BIRTH, NEW_STAFF_SALARY, NEW_STAFF_IS_DELETED);

        given(StaffRepository.save(Staff1)).willReturn(Staff1);

        Staff created = StaffService.save(Staff1);

        assertEquals(NEW_STAFF_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        Staff1.setId(DB_STAFF_ID);

        Mockito.when(StaffRepository.findById(DB_STAFF_ID)).thenThrow(ResponseStatusException.class);

        Staff Staff = StaffService.delete(DB_STAFF_ID);
    }

    @Test
    public void testDelete1(){
        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        Staff1.setId(DB_STAFF_ID);

        Mockito.when(StaffRepository.findById(DB_STAFF_ID)).thenReturn(Optional.of(Staff1));

        Staff deletedStaff = Staff1;
        deletedStaff.setIsDeleted(true);

        Mockito.when(StaffRepository.save(Staff1)).thenReturn(deletedStaff);

        Staff Staff = StaffService.delete(DB_STAFF_ID);

        assertEquals(true, Staff.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED_UNIT);
        Staff1.setId(DB_STAFF_ID);

        given(StaffRepository.findById(DB_STAFF_ID)).willReturn(java.util.Optional.of(Staff1));

        Staff deletedStaff = Staff1;
        deletedStaff.setIsDeleted(true);

        Mockito.when(StaffRepository.save(Staff1)).thenReturn(deletedStaff);

        Staff tested_STAFF = StaffService.delete(Staff1);
        assertEquals(true, tested_STAFF.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Staff Staff1 = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        Staff1.setId(DB_WRONG_STAFF_ID);

        Mockito.when(StaffRepository.findById(DB_WRONG_STAFF_ID)).thenThrow(ResponseStatusException.class);

        Staff tested_STAFF = StaffService.delete(Staff1);
    }
}
