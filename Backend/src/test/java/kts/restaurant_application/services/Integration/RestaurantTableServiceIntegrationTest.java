package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.services.TableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static kts.restaurant_application.constants.ResourantTablesConstants.*;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class RestaurantTableServiceIntegrationTest {

    @Autowired
    private TableService restorantTablesService;

    @Test
    public void testFindAll() {
        Iterable<RestourantTables> found = restorantTablesService.findAll();

        int count = 0;
        for(RestourantTables u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_RESTOURANT_TABLES, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        restorantTablesService.findOne(DB_WRONG_RESTOURANT_TABLE_ID);
    }

    @Test
    public void testFindOne() {
        RestourantTables found = restorantTablesService.findOne(DB_RESTOURANT_TABLE_ID);
        assertEquals(DB_RESTOURANT_TABLE_ID, found.getId());
    }


    @Test
    public void testSave(){
        RestourantTables RestorantTables = new RestourantTables(DB_NEW_RESTOURANT_TABLE_NUMBER, DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );

        RestourantTables created = restorantTablesService.save(RestorantTables);

        assertEquals(DB_NEW_RESTOURANT_TABLE_NUMBER, created.getTableNumber());
    }

    @Test
    public void testDelete1(){
        RestourantTables RestorantTables = restorantTablesService.delete(DB_RESTOURANT_TABLE_ID);
        assertEquals(true, RestorantTables.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        RestourantTables restorantTables = new RestourantTables(DB_RESTOURANT_TABLE_NUMBER, DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y,DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED );
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        RestourantTables tested_table = restorantTablesService.delete(restorantTables);
        assertEquals(true, tested_table.getIsDeleted());
    }
}
