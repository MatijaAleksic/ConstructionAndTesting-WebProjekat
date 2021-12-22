package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;


import static kts.restaurant_application.constants.ItemConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ItemServiceIntegrationTest {

    @Autowired
    private ItemService ItemService;

    @Test
    public void testFindAll() {
        Iterable<Item> found = ItemService.findAll();

        int count = 0;
        for(Item u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ITEMS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        ItemService.findOne(DB_WRONG_ITEM_ID);
    }

    @Test
    public void testFindOne() {
        Item found = ItemService.findOne(DB_ITEM_ID);
        assertEquals(DB_ITEM_ID, found.getId());
    }

    @Test
    public void testSave(){

        Item item = new Item(DB_NEW_ITEM_PRICE, DB_NEW_ITEM_PRIPRITY, DB_NEW_ITEM_SUBCATEGORY, DB_NEW_ITEM_DESCRIPTION, DB_NEW_ITEM_IS_DELETED, DB_NEW_ITEM_NAME);

        Item created = ItemService.save(item);

        assertEquals(DB_NEW_ITEM_NAME, created.getName());
    }

    @Test
    public void testDelete1(){
        Item item = ItemService.delete(DB_ITEM_ID);
        assertEquals(true, item.getIsDeleted());
    }

    @Test
    public void testDelete2(){
        Item item = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        item.setId(DB_ITEM_ID);

        Item tested_ITEM = ItemService.delete(item);
        assertEquals(true, tested_ITEM.getIsDeleted());
    }
}
