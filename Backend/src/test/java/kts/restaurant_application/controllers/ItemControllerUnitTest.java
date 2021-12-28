package kts.restaurant_application.controllers;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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

import kts.restaurant_application.model.Item;
import kts.restaurant_application.services.ItemService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerUnitTest {

    @Autowired
	private TestRestTemplate restTemplate;

    @MockBean
    private ItemService itemService;

    
    @Test
    public void testCreate() {
        Item newItem = new Item(99l, 0l, 22.22, (byte)1, "sub", "description", false, "name");

        Mockito.when(itemService.save(newItem)).thenReturn(newItem);
      ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
				"/items", newItem, Item.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDelete() {
        Item newItem = new Item();
        newItem.setDeleted(true);
        newItem.setId(1l);
        Mockito.when(itemService.delete(1l)).thenReturn(newItem);
        Mockito.when(itemService.delete(999l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
            "/items/delete/1", 1, Item.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    Item user = responseEntity.getBody();
    assertEquals(user.getIsDeleted(), true);
    ResponseEntity<Object> responseEntity2;
    responseEntity2 = restTemplate.postForEntity(
            "/items/delete/999", 999, Object.class);
    assertEquals(HttpStatus.NOT_FOUND, responseEntity2.getStatusCode()); // tries to interprate HTTP.STATUS as a itemStatus enum
    }

    @Test
    public void testFindAll() {
        Item item1 = new Item();
        item1.setName("name");
        ArrayList<Item> list = new ArrayList<>();
        list.add(item1);
        Mockito.when(itemService.findAll()).thenReturn(list);
        ResponseEntity<Item[]> responseEntity = restTemplate
				.getForEntity("/items/", Item[].class);

        Item[] categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(1, categories.length);
		assertEquals("name", categories[0].getName());
    }

    @Test
    public void testFindOne() {
        Item item1 = new Item();
        item1.setName("name");
        Mockito.when(itemService.findOne(1l)).thenReturn(item1);
        ResponseEntity<Item> responseEntity = restTemplate
				.getForEntity("/items/1", Item.class);

        Item categories = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("name", categories.getName());
    }

    @Test
    public void testUpdate() {
        Item newAdmin = new Item(1l, 0l, 22.22, (byte)1, "sub", "description", false, "name");
		Mockito.when(itemService.update(newAdmin)).thenReturn(newAdmin);
		ResponseEntity<Item> responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin, Item.class);

                Item response = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(newAdmin.getName(), response.getName());

        Item newAdmin2 = new Item(1l, 0l, 22.22, (byte)1, "sub", "description", false, "name123");
		Mockito.when(itemService.update(newAdmin2)).thenReturn(newAdmin2);
        

        responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin2, Item.class);
                Item response2 = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		assertEquals(response2.getName().equals(response.getName()), false);
        
        Item newAdmin3 = new Item(99991l, 0l, 22.22, (byte)1, "sub", "description", false, "name12345");
		Mockito.when(itemService.update(newAdmin3)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

    responseEntity = restTemplate.postForEntity(
				"/items/update", newAdmin3, Item.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
    
}
