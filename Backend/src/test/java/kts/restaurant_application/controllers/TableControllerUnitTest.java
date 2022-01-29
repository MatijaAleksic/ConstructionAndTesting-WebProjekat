package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.constants.ResourantTablesConstants;
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.TableStatus;
import kts.restaurant_application.services.TableService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TableControllerUnitTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private TableService tableService;

    @Test
    public void testCreateStatusOk() {
        RestourantTables table = new RestourantTables( 3, 20.5, 24.55,TableStatus.free , false);
        Mockito.when(tableService.save(table)).thenReturn(table);
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables", table, RestourantTables.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateInternalServerError(){
        RestourantTables table = new RestourantTables(3, 20.5, 24.55,TableStatus.free , false);
        Mockito.when(tableService.save(table)).thenThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));

        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables", table, RestourantTables.class);
                // does not work in unit tests for some reason
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteStatusOk() {
        Mockito.when(tableService.delete(1l)).thenReturn(new RestourantTables());
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/delete/1", 1, RestourantTables.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteStatusNotFound() {
        Mockito.when(tableService.delete(3l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/delete/3", 1, RestourantTables.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testFindAll() {
        ArrayList<RestourantTables> responseTables = new ArrayList<>();
        RestourantTables t = new RestourantTables();
        t.setId(1l);
        responseTables.add(t);
        responseTables.add(new RestourantTables());
        Mockito.when(this.tableService.findAll()).thenReturn(responseTables);
        ResponseEntity<RestourantTables[]> responseEntity = restTemplate
                .getForEntity("/tables/", RestourantTables[].class);

        RestourantTables[] tables = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(ResourantTablesConstants.FIND_ALL_NUMBER_OF_RESTOURANT_TABLES, tables.length);
        assertEquals(ResourantTablesConstants.DB_RESTOURANT_TABLE_NUMBER, tables[0].getId());
    }

    @Test
    public void testFindOne() {
        RestourantTables t = new RestourantTables();
        t.setId(1l);
        Mockito.when(this.tableService.findOne(1l)).thenReturn(t);
        ResponseEntity<RestourantTables> responseEntity = restTemplate
                .getForEntity("/tables/1", RestourantTables.class);

        RestourantTables table = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(ResourantTablesConstants.DB_RESTOURANT_TABLE_NUMBER, table.getId());
    }

    @Test
    public void testUpdate() {
        Set<Order> EmptySet = Collections.<Order>emptySet();
        RestourantTables table = new RestourantTables(1l, 5l, 1, 321.22, 3213.22, TableStatus.free, false, EmptySet);
        Mockito.when(this.tableService.update(table)).thenReturn(table);
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/update", table, RestourantTables.class);

        RestourantTables response = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        

    }
}
