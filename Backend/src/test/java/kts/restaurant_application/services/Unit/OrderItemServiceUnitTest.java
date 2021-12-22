package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.Notification;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.repositories.OrderedItemRepository;
import kts.restaurant_application.repositories.NotificationRepository;
import kts.restaurant_application.services.OrderedItemService;
import kts.restaurant_application.services.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kts.restaurant_application.constants.OrderedItemConstants.*;
import static kts.restaurant_application.constants.OrderedItemConstants.DB_ORDERED_ITEM_STATE_UNIT2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderItemServiceUnitTest {

    @Autowired
    private OrderedItemService OrderedItemService;

    @MockBean
    private OrderedItemRepository OrderedItemRepository;

    @Test
    public void testFindAll() {
        List<OrderedItem> OrderedItems = new ArrayList<>();

        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem OrderedItem2 = new OrderedItem(DB_ORDERED_ITEM_NOTE_UNIT1, DB_ORDERED_ITEM_STATE_UNIT1, DB_ORDERED_ITEM_NUMBER_UNIT1, DB_ORDERED_ITEM_DATETIME_UNIT1, DB_ORDERED_ITEM_PRICE_UNIT1);
        OrderedItem OrderedItem3 = new OrderedItem(DB_ORDERED_ITEM_NOTE_UNIT2, DB_ORDERED_ITEM_STATE_UNIT2, DB_ORDERED_ITEM_NUMBER_UNIT2, DB_ORDERED_ITEM_DATETIME_UNIT2, DB_ORDERED_ITEM_PRICE_UNIT2);
        OrderedItems.add(OrderedItem1);
        OrderedItems.add(OrderedItem2);
        OrderedItems.add(OrderedItem3);

        given(OrderedItemRepository.findAll()).willReturn(OrderedItems);

        Iterable<OrderedItem> found = OrderedItemService.findAll();

        int count = 0;
        for(OrderedItem u : found){
            count += 1;
        }
        assertEquals(DB_SAVED_ORDERED_ITEM_ID_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(OrderedItemRepository.findById(DB_WRONG_ORDERED_ITEM_ID))
                .willThrow(ResponseStatusException.class);


        OrderedItemService.findOne(DB_WRONG_ORDERED_ITEM_ID);
    }

    @Test
    public void testFindOne() {
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem1.setId(DB_ORDERED_ITEM_ID);

        Mockito.when(OrderedItemRepository.findById(DB_ORDERED_ITEM_ID))
                .thenReturn(java.util.Optional.of(OrderedItem1));

        OrderedItem found = OrderedItemService.findOne(DB_ORDERED_ITEM_ID);
        assertEquals(DB_ORDERED_ITEM_ID, found.getId());
    }

    @Test
    public void testSave(){
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);

        given(OrderedItemRepository.save(OrderedItem1)).willReturn(OrderedItem1);

        OrderedItem created = OrderedItemService.save(OrderedItem1);

        assertEquals(DB_ORDERED_ITEM_NOTE, created.getNote());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem1.setId(DB_ORDERED_ITEM_ID);

        Mockito.when(OrderedItemRepository.findById(DB_ORDERED_ITEM_ID)).thenThrow(ResponseStatusException.class);

        boolean OrderedItem = OrderedItemService.delete(DB_ORDERED_ITEM_ID);
    }

    @Test
    public void testDelete1(){
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem1.setId(DB_ORDERED_ITEM_ID);

        Mockito.when(OrderedItemRepository.findById(DB_ORDERED_ITEM_ID)).thenReturn(Optional.of(OrderedItem1));

        boolean OrderedItem = OrderedItemService.delete(DB_ORDERED_ITEM_ID);

        assertTrue(OrderedItem);
    }



    @Test
    public void testDelete2(){
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem1.setId(DB_ORDERED_ITEM_ID);

        given(OrderedItemRepository.findById(DB_ORDERED_ITEM_ID)).willReturn(java.util.Optional.of(OrderedItem1));

        boolean tested_ORDERED_ITEM = OrderedItemService.delete(OrderedItem1);
        assertTrue(tested_ORDERED_ITEM);
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        OrderedItem OrderedItem1 = new OrderedItem(DB_ORDERED_ITEM_NOTE, DB_ORDERED_ITEM_STATE, DB_ORDERED_ITEM_NUMBER, DB_ORDERED_ITEM_DATETIME, DB_ORDERED_ITEM_PRICE);
        OrderedItem1.setId(DB_WRONG_ORDERED_ITEM_ID);

        Mockito.when(OrderedItemRepository.findById(DB_WRONG_ORDERED_ITEM_ID)).thenThrow(ResponseStatusException.class);
        doNothing().when(OrderedItemRepository).delete(OrderedItem1);

        boolean tested_ORDERED_ITEM = OrderedItemService.delete(OrderedItem1);
    }
}
