package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.repositories.AdminRepository;
import kts.restaurant_application.services.AdminService;
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

import static kts.restaurant_application.constants.AdminConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class AdminServiceUnitTest {

    @Autowired
    private AdminService AdminService;

    @MockBean
    private AdminRepository AdminRepository;

    @Test
    public void testFindAll() {
        List<Admin> Admins = new ArrayList<>();

        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin Admin2 = new Admin(DB_ADMIN_FIRSTNAME_UNIT1, DB_ADMIN_LASTNAME_UNIT1, DB_ADMIN_USERNAME_UNIT1, DB_ADMIN_PASSWORD_UNIT1, DB_ADMIN_DATE_OF_BIRTH_UNIT1, DB_ADMIN_SALARY_UNIT1, DB_ADMIN_IS_DELETED_UNIT1);
        Admin Admin3 = new Admin(DB_ADMIN_FIRSTNAME_UNIT2, DB_ADMIN_LASTNAME_UNIT2, DB_ADMIN_USERNAME_UNIT2, DB_ADMIN_PASSWORD_UNIT2, DB_ADMIN_DATE_OF_BIRTH_UNIT2, DB_ADMIN_SALARY_UNIT2, DB_ADMIN_IS_DELETED_UNIT2);
        Admins.add(Admin1);
        Admins.add(Admin2);
        Admins.add(Admin3);

        given(AdminRepository.findAll()).willReturn(Admins);

        Iterable<Admin> found = AdminService.findAll();

        int count = 0;
        for(Admin u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ADMIN_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(AdminRepository.findById(DB_WRONG_ADMIN_ID))
                .willThrow(ResponseStatusException.class);


        AdminService.findOne(DB_WRONG_ADMIN_ID);
    }

    @Test
    public void testFindOne() {
        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin1.setId(DB_ADMIN_ID);

        Mockito.when(AdminRepository.findById(DB_ADMIN_ID))
                .thenReturn(java.util.Optional.of(Admin1));

        Admin found = AdminService.findOne(DB_ADMIN_ID);
        assertEquals(DB_ADMIN_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        Admin Admin1 = new Admin(NEW_ADMIN_FIRSTNAME, NEW_ADMIN_LASTNAME, NEW_ADMIN_USERNAME,
                NEW_ADMIN_PASSWORD, NEW_ADMIN_DATE_OF_BIRTH, NEW_ADMIN_SALARY, NEW_ADMIN_IS_DELETED);

        given(AdminRepository.save(Admin1)).willReturn(Admin1);

        Admin created = AdminService.save(Admin1);

        assertEquals(NEW_ADMIN_USERNAME, created.getUsername());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException() throws Exception {
        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin1.setId(DB_ADMIN_ID);

        Mockito.when(AdminRepository.findById(DB_ADMIN_ID)).thenThrow(ResponseStatusException.class);

        Admin Admin = AdminService.delete(DB_ADMIN_ID);
    }

    @Test
    public void testDelete1() throws Exception {
        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin1.setId(DB_ADMIN_ID);

        Mockito.when(AdminRepository.findById(DB_ADMIN_ID)).thenReturn(Optional.of(Admin1));

        Admin deletedAdmin = Admin1;
        deletedAdmin.setIsDeleted(true);

        Mockito.when(AdminRepository.save(Admin1)).thenReturn(deletedAdmin);

        Admin Admin = AdminService.delete(DB_ADMIN_ID);

        assertEquals(true, Admin.getIsDeleted());
    }



    @Test
    public void testDelete2() throws Exception {
        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED_UNIT);
        Admin1.setId(DB_ADMIN_ID);

        given(AdminRepository.findById(DB_ADMIN_ID)).willReturn(java.util.Optional.of(Admin1));

        Admin deletedAdmin = Admin1;
        deletedAdmin.setIsDeleted(true);

        Mockito.when(AdminRepository.save(Admin1)).thenReturn(deletedAdmin);

        Admin tested_ADMIN = AdminService.delete(Admin1);
        assertEquals(true, tested_ADMIN.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException() throws Exception {
        Admin Admin1 = new Admin(DB_ADMIN_FIRSTNAME, DB_ADMIN_LASTNAME, DB_ADMIN_USERNAME, DB_ADMIN_PASSWORD, DB_ADMIN_DATE_OF_BIRTH, DB_ADMIN_SALARY, DB_ADMIN_IS_DELETED);
        Admin1.setId(DB_WRONG_ADMIN_ID);

        Mockito.when(AdminRepository.findById(DB_WRONG_ADMIN_ID)).thenThrow(ResponseStatusException.class);

        Admin tested_ADMIN = AdminService.delete(Admin1);
    }
}
