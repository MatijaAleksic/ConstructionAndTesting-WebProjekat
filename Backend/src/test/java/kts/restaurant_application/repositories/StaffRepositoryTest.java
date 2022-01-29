package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.model.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static kts.restaurant_application.constants.StaffConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class StaffRepositoryTest {

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void testFindStaffByUsername() throws ParseException {

        Optional<Staff> found = staffRepository.findByUsername(DB_STAFF_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindStaffByWrongUsername() throws ParseException {

        Optional<Staff> found = staffRepository.findByUsername(WRONG_STAFF_USERNAME);

        assertFalse(found.isPresent());
    }
}
