package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.OrderedItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static kts.restaurant_application.constants.AdminConstants.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testFindAdminByUsername() throws ParseException {

        Optional<Admin> found = adminRepository.findByUsername(DB_ADMIN_USERNAME1);

        assertTrue(found.isPresent());
    }

    @Test
    public void testFindAdminByWrongUsername() throws ParseException {

        Optional<Admin> found = adminRepository.findByUsername(WRONG_ADMIN_USERNAME);

        assertFalse(found.isPresent());
    }



}
