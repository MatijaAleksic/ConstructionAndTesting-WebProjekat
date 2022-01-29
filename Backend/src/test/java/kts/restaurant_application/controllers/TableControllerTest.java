package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.constants.ResourantTablesConstants;
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.TableStatus;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class TableControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateStatusOk() {
        RestourantTables table = new RestourantTables(3, 20.5, 24.55,TableStatus.free , false);

        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables", table, RestourantTables.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateInternalServerError(){
        RestourantTables table = new RestourantTables(3, 20.5, 24.55,TableStatus.free , false);

        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables", table, RestourantTables.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteStatusOk() {
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/delete/1", 1, RestourantTables.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteStatusNotFound() {
        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/delete/3", 1, RestourantTables.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testFindAll() {
        ResponseEntity<RestourantTables[]> responseEntity = restTemplate
                .getForEntity("/tables/", RestourantTables[].class);

        RestourantTables[] tables = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(ResourantTablesConstants.FIND_ALL_NUMBER_OF_RESTOURANT_TABLES, tables.length);
        assertEquals(ResourantTablesConstants.DB_RESTOURANT_TABLE_NUMBER, tables[0].getId());
    }

    @Test
    public void testFindOne() {
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

        ResponseEntity<RestourantTables> responseEntity = restTemplate.postForEntity(
                "/tables/update", table, RestourantTables.class);

        RestourantTables response = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        

    }
}
