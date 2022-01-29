package kts.restaurant_application.repositories;

import kts.restaurant_application.model.RestourantTables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class TableRepositoryTest {

    @Autowired
    private TableRepository tableRepository;

    @Test
    public void testFindTableAllByFloor() throws ParseException {

        RestourantTables[] tables = tableRepository.findAllByFloor(1);

        assertEquals(1,tables.length);
    }

    @Test
    public void testFindAllByIsDeleted() throws ParseException {

        Collection<RestourantTables> tables = tableRepository.findAllByIsDeleted(false);

        assertEquals(2, tables.size());
    }

    @Test
    public void testfindByIdAndIsDeleted() throws ParseException {

        Optional<RestourantTables> tables = tableRepository.findByIdAndIsDeleted(1L, false);

        assertTrue(tables.isPresent());
    }

    @Test
    public void testFindAllByFloorAndIsDeleted() throws ParseException {

        RestourantTables[] tables = tableRepository.findAllByFloorAndIsDeleted(1, false);

        assertEquals(1, tables.length);
    }

}
