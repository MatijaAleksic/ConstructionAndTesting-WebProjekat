package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.services.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.ManagerConstants.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ManagerServiceIntegrationTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void testFindAll() {
        Iterable<Manager> found = managerService.findAll();

        int count = 0;
        for(Manager u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_MANAGERS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        managerService.findOne(DB_WRONG_MANAGER_ID);
    }

    @Test
    public void testFindOne() {
        Manager found = managerService.findOne(DB_MANAGER_ID);
        assertEquals(DB_MANAGER_ID, found.getId());
    }

    @Test
    public void testSave() throws Exception {
        Manager manager = new Manager(NEW_MANAGER_FIRSTNAME, NEW_MANAGER_LASTNAME, NEW_MANAGER_USERNAME,
                NEW_MANAGER_PASSWORD, NEW_MANAGER_DATE_OF_BIRTH, NEW_MANAGER_SALARY, NEW_MANAGER_IS_DELETED);

        Manager created = managerService.save(manager);

        assertEquals(NEW_MANAGER_USERNAME, created.getUsername());
    }

    @Test
    public void testDelete1() throws Exception {
        Manager manager = managerService.delete(DB_MANAGER_ID);
        assertEquals(true, manager.getIsDeleted());
    }

    @Test
    public void testDelete2() throws Exception {
        Manager manager = new Manager(DB_MANAGER_FIRSTNAME, DB_MANAGER_LASTNAME, DB_MANAGER_USERNAME, DB_MANAGER_PASSWORD, DB_MANAGER_DATE_OF_BIRTH, DB_MANAGER_SALARY, DB_MANAGER_IS_DELETED);
        manager.setId(DB_MANAGER_ID);

        Manager tested_manager = managerService.delete(manager);
        assertEquals(true, tested_manager.getIsDeleted());
    }
}
