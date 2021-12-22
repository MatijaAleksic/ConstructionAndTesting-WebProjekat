package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Staff;
import kts.restaurant_application.services.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.StaffConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class StaffServiceIntegrationTest {

    @Autowired
    private StaffService staffService;

    @Test
    public void testFindAll() {
        Iterable<Staff> found = staffService.findAll();

        int count = 0;
        for(Staff u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_STAFFS, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        staffService.findOne(DB_WRONG_STAFF_ID);
    }

    @Test
    public void testFindOne() {
        Staff found = staffService.findOne(DB_STAFF_ID);
        assertEquals(DB_STAFF_ID, found.getId());
    }

    @Test
    public void testSave(){
        Staff staff = new Staff(NEW_STAFF_FIRSTNAME, NEW_STAFF_LASTNAME, NEW_STAFF_USERNAME,
                NEW_STAFF_PASSWORD, NEW_STAFF_DATE_OF_BIRTH, NEW_STAFF_SALARY, NEW_STAFF_IS_DELETED);

        Staff created = staffService.save(staff);

        assertEquals(NEW_STAFF_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1(){
        Staff staff = staffService.delete(DB_STAFF_ID);
        assertEquals(true, staff.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldThrowResponseStatusException(){
        Staff staff = staffService.delete(DB_WRONG_STAFF_ID);
        assertEquals(true, staff.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Staff staff = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED);
        staff.setId(DB_STAFF_ID);

        Staff tested_staff= staffService.delete(staff);
        assertEquals(true, tested_staff.getIsDeleted());
    }
}
