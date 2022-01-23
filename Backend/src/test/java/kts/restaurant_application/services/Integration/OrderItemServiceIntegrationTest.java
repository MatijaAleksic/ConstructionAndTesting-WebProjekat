package kts.restaurant_application.services.Integration;

import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_DESCRIPTION;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_ID;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_IS_DELETED;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_NAME;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_PRICE;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_PRIPRITY;
import static kts.restaurant_application.constants.ItemConstants.DB_ITEM_SUBCATEGORY;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_DATETIME;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_ID;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_NOTE;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_NUMBER;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_PRICE;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_STATE;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_WRONG_ORDERED_ITEM_ID;
import static kts.restaurant_application.constants.OrderedItemConstants.FIND_ALL_NUMBER_OF_ORDERED_ITEMS;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_DATETIME;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_ID;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_NOTE;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_NUMBER;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_PRICE;
import static kts.restaurant_application.constants.OrderedItemConstants.NEW_ORDERED_ITEM_STATE;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_DATE_OF_BIRTH;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_FIRSTNAME;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_ID;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_IS_DELETED_UNIT;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_LASTNAME;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_PASSWORD;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_SALARY;
import static kts.restaurant_application.constants.StaffConstants.DB_STAFF_USERNAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.Staff;
import kts.restaurant_application.services.OrderedItemService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public class OrderItemServiceIntegrationTest {

    @Autowired
    private OrderedItemService orderedItemService;

    @Test
    public void testFindAll() {
        Iterable<OrderedItem> found = orderedItemService.findAll();

        int count = 0;
        for(OrderedItem u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ORDERED_ITEMS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        orderedItemService.findOne(DB_WRONG_ORDERED_ITEM_ID);
    }

    @Test
    public void testFindOne() {
        OrderedItem found = orderedItemService.findOne(DB_ORDERED_ITEM_ID);
        assertEquals(DB_ORDERED_ITEM_ID, found.getId());
    }

    @Test
    public void testSave(){
        OrderedItem item = new OrderedItem(NEW_ORDERED_ITEM_NOTE, NEW_ORDERED_ITEM_STATE, NEW_ORDERED_ITEM_NUMBER, NEW_ORDERED_ITEM_DATETIME, NEW_ORDERED_ITEM_PRICE);
        item.setId(100L);
        OrderedItem created = orderedItemService.save(item);

        assertEquals(NEW_ORDERED_ITEM_ID, created.getId());
    }

    @Test
    public void testDeleteShouldReturnTrue(){
        boolean flag = orderedItemService.delete(DB_ORDERED_ITEM_ID);
        assertTrue(flag);
    }

    @Test(expected = ResponseStatusException.class)
    public void testDeleteShouldReturnResponseStatusException(){
        boolean flag = orderedItemService.delete(DB_WRONG_ORDERED_ITEM_ID);
    }

    @Test
    public void testDelete2(){
        OrderedItem ordered_item = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);

        Item item = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        item.setId(DB_ITEM_ID);

        Staff staff = new Staff(DB_STAFF_FIRSTNAME, DB_STAFF_LASTNAME, DB_STAFF_USERNAME, DB_STAFF_PASSWORD, DB_STAFF_DATE_OF_BIRTH, DB_STAFF_SALARY, DB_STAFF_IS_DELETED_UNIT);
        staff.setId(DB_STAFF_ID);

        ordered_item.setItem(item);
        ordered_item.setStaff(staff);

        ordered_item.setId(DB_ORDERED_ITEM_ID + 1);

        boolean flag = orderedItemService.delete(ordered_item);
        assertTrue(flag);
    }
}
