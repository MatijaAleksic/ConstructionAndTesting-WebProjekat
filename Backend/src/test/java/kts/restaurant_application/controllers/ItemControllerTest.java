package kts.restaurant_application.controllers;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.constants.Constants;
import kts.restaurant_application.model.Item;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ItemControllerTest {

    @Autowired
	private TestRestTemplate restTemplate;

    
    @Test
    public void testCreate() {
        Item newItem = new Item(99l, 0l, 22.22, (byte)1, "sub", "description", false, "name");

      ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
				"/items", newItem, Item.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDelete() {
        ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
            "/items/delete/1", 1, Item.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    Item user = responseEntity.getBody();
    assertEquals(user.getIsDeleted(), true);
    ResponseEntity<Object> responseEntity2;
    responseEntity2 = restTemplate.postForEntity(
            "/items/delete/999", 999, Object.class);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity2.getStatusCode()); // tries to interprate HTTP.STATUS as a itemStatus enum
    }

    @Test
    public void testFindAll() {
        ResponseEntity<Item[]> responseEntity = restTemplate
				.getForEntity("/items/", Item[].class);

        Item[] categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(Constants.NUM_OF_ITEMS, categories.length);
		assertEquals(Constants.ITEM_NAME, categories[0].getName());
    }

    @Test
    public void testFindOne() {
        ResponseEntity<Item> responseEntity = restTemplate
				.getForEntity("/items/1", Item.class);

        Item categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(Constants.ITEM_NAME, categories.getName());
    }

    @Test
    public void testUpdate() {
        Item newAdmin = new Item(1l, 0l, 22.22, (byte)1, "sub", "description", false, "nameasdfasdf");
		
		ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin, Item.class);

                Item response = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(newAdmin.getName(), response.getName());

        Item newAdmin2 = new Item(1l, 0l, 22.22, (byte)1, "sub", "description", false, "name123");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin2, Item.class);
                Item response2 = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		assertEquals(response2.getName().equals(response.getName()), false);
        Item newAdmin3 = new Item(99991l, 0l, 22.22, (byte)1, "sub", "description", false, "name12345");
    responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin3, Item.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
