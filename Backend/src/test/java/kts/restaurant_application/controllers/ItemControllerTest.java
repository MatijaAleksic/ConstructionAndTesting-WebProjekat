package kts.restaurant_application.controllers;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import kts.restaurant_application.model.Item;

public class ItemControllerTest {

    @Autowired
	private TestRestTemplate restTemplate;

    
    @Test
    public void testCreate() {
        Item newItem = new Item(99l, 0l, 22.22, (byte)1, "sub", "description", false, "name");

      ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
				"/items", newItem, Item.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        responseEntity = restTemplate.postForEntity(
            "/items", newItem, Item.class);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testFindAll() {

    }

    @Test
    public void testFindOne() {

    }

    @Test
    public void testUpdate() {

    }
}
