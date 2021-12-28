package kts.restaurant_application.services.Integration;

import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_DATE_OF_BIRTH;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_FIRSTNAME;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_ID;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_IS_DELETED;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_LASTNAME;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_PASSWORD;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_SALARY;
import static kts.restaurant_application.constants.AdminConstants.DB_ADMIN_USERNAME;
import static kts.restaurant_application.constants.AdminConstants.DB_WRONG_ADMIN_ID;
import static kts.restaurant_application.constants.AdminConstants.FIND_ALL_NUMBER_OF_ADMINS;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_DATE_OF_BIRTH;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_FIRSTNAME;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_IS_DELETED;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_LASTNAME;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_PASSWORD;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_SALARY;
import static kts.restaurant_application.constants.AdminConstants.NEW_ADMIN_USERNAME;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.services.AdminService;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class AdminServiceIntegrationTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testFindAll() {
        Iterable<Admin> found = adminService.findAll();

        int count = 0;
        for(Admin u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ADMINS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        adminService.findOne(DB_WRONG_ADMIN_ID);
    }

    @Test
    public void testFindOne() {
        Admin found = adminService.findOne(DB_ADMIN_ID);
        assertEquals(DB_ADMIN_ID, found.getId());
    }

    @Test
    public void testSave(){
        Admin Admin = new Admin(NEW_ADMIN_FIRSTNAME, NEW_ADMIN_LASTNAME, NEW_ADMIN_USERNAME,
                NEW_ADMIN_PASSWORD, NEW_ADMIN_DATE_OF_BIRTH, NEW_ADMIN_SALARY, NEW_ADMIN_IS_DELETED);

        Admin created = adminService.save(Admin);

        assertEquals(NEW_ADMIN_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1(){
        Admin Admin = adminService.delete(DB_ADMIN_ID);
        assertEquals(true, Admin.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Admin Admin = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin.setId(DB_ADMIN_ID);

        Admin tested_ADMIN = adminService.delete(Admin);
        assertEquals(true, tested_ADMIN.getIsDeleted());
    }
}
