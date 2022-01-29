package kts.restaurant_application.services.Unit;

import static kts.restaurant_application.constants.ResourantTablesConstants.DB_NEW_RESTOURANT_TABLE_FLOOR;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_NEW_RESTOURANT_TABLE_IS_DELETED;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_NEW_RESTOURANT_TABLE_POSITION_X;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_NEW_RESTOURANT_TABLE_POSITION_Y;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_NEW_RESTOURANT_TABLE_STATE;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_FLOOR_UNIT1;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_FLOOR_UNIT2;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_ID;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_IS_DELETED_UNIT1;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_IS_DELETED_UNIT2;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_X_UNIT1;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_X_UNIT2;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_Y_UNIT1;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_Y_UNIT2;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_STATE_UNIT1;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_STATE_UNIT2;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_WRONG_RESTOURANT_TABLE_ID;
import static kts.restaurant_application.constants.ResourantTablesConstants.FIND_ALL_NUMBER_OF_RESTOURANT_TABLE_UNIT;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.repositories.TableRepository;
import kts.restaurant_application.services.TableService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class RestourantTableServiceUnitTest {
    @Autowired
    private TableService RestourantTablesService;

    @MockBean
    private TableRepository RestourantTablesRepository;

    @Test
    public void testFindAll() {
        List<RestourantTables> RestourantTabless = new ArrayList<>();

        RestourantTables RestorantTables = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables RestourantTables2 = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR_UNIT1, DB_RESTOURANT_TABLE_POSITION_X_UNIT1, DB_RESTOURANT_TABLE_POSITION_Y_UNIT1,DB_RESTOURANT_TABLE_STATE_UNIT1, DB_RESTOURANT_TABLE_IS_DELETED_UNIT1 );
        RestourantTables RestourantTables3 = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR_UNIT2, DB_RESTOURANT_TABLE_POSITION_X_UNIT2, DB_RESTOURANT_TABLE_POSITION_Y_UNIT2,DB_RESTOURANT_TABLE_STATE_UNIT2, DB_RESTOURANT_TABLE_IS_DELETED_UNIT2 );
        RestourantTabless.add(RestorantTables);
        RestourantTabless.add(RestourantTables2);
        RestourantTabless.add(RestourantTables3);

        given(RestourantTablesRepository.findAll()).willReturn(RestourantTabless);

        Iterable<RestourantTables> found = RestourantTablesService.findAll();

        int count = 0;
        for(RestourantTables u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_RESTOURANT_TABLE_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(RestourantTablesRepository.findById(DB_WRONG_RESTOURANT_TABLE_ID))
                .willThrow(ResponseStatusException.class);


        RestourantTablesService.findOne(DB_WRONG_RESTOURANT_TABLE_ID);
    }

    @Test
    public void testFindOne() {
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables1.setId(DB_RESTOURANT_TABLE_ID);

        Mockito.when(RestourantTablesRepository.findById(DB_RESTOURANT_TABLE_ID))
                .thenReturn(java.util.Optional.of(RestourantTables1));

        RestourantTables found = RestourantTablesService.findOne(DB_RESTOURANT_TABLE_ID);
        assertEquals(DB_RESTOURANT_TABLE_ID, found.getId());
    }

    @Test
    public void testSave(){
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );

        given(RestourantTablesRepository.save(RestourantTables1)).willReturn(RestourantTables1);

        RestourantTables created = RestourantTablesService.save(RestourantTables1);

        assertEquals(DB_NEW_RESTOURANT_TABLE_FLOOR, created.getFloor());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables1.setId(DB_RESTOURANT_TABLE_ID);

        Mockito.when(RestourantTablesRepository.findById(DB_RESTOURANT_TABLE_ID)).thenThrow(ResponseStatusException.class);

        RestourantTables RestourantTables = RestourantTablesService.delete(DB_RESTOURANT_TABLE_ID);
    }

    @Test
    public void testDelete1(){
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables1.setId(DB_RESTOURANT_TABLE_ID);

        Mockito.when(RestourantTablesRepository.findById(DB_RESTOURANT_TABLE_ID)).thenReturn(Optional.of(RestourantTables1));

        RestourantTables deletedRestourantTables = RestourantTables1;
        deletedRestourantTables.setIsDeleted(true);

        Mockito.when(RestourantTablesRepository.save(RestourantTables1)).thenReturn(deletedRestourantTables);

        RestourantTables RestourantTables = RestourantTablesService.delete(DB_RESTOURANT_TABLE_ID);

        assertEquals(true, RestourantTables.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables1.setId(DB_RESTOURANT_TABLE_ID);

        given(RestourantTablesRepository.findById(DB_RESTOURANT_TABLE_ID)).willReturn(java.util.Optional.of(RestourantTables1));

        RestourantTables deletedRestourantTables = RestourantTables1;
        deletedRestourantTables.setIsDeleted(true);

        Mockito.when(RestourantTablesRepository.save(RestourantTables1)).thenReturn(deletedRestourantTables);

        RestourantTables tested_RESTOURNAT_TABLE = RestourantTablesService.delete(RestourantTables1);
        assertEquals(true, tested_RESTOURNAT_TABLE.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        RestourantTables RestourantTables1 = new RestourantTables( DB_NEW_RESTOURANT_TABLE_FLOOR, DB_NEW_RESTOURANT_TABLE_POSITION_X, DB_NEW_RESTOURANT_TABLE_POSITION_Y,DB_NEW_RESTOURANT_TABLE_STATE, DB_NEW_RESTOURANT_TABLE_IS_DELETED );
        RestourantTables1.setId(DB_RESTOURANT_TABLE_ID);

        Mockito.when(RestourantTablesRepository.findById(DB_RESTOURANT_TABLE_ID)).thenThrow(ResponseStatusException.class);

        RestourantTables tested_RESTOURNAT_TABLE = RestourantTablesService.delete(RestourantTables1);
    }
}
