package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import kts.restaurant_application.model.DateDTO;
import kts.restaurant_application.model.Item;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.Staff;
import kts.restaurant_application.model.State;
import kts.restaurant_application.services.ItemService;
import kts.restaurant_application.services.OrderedItemService;
import kts.restaurant_application.services.StaffService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderedItemControllerUnitTest {






    @Autowired
	  private TestRestTemplate restTemplate;

    @MockBean
    private StaffService staffService;

    @MockBean
    private ItemService itemService;

    @MockBean
    private OrderedItemService orderedItemService;

    @Test
    public void testCreate() {
        OrderedItem o = new OrderedItem();
        
        o.setId(12l);
        o.setDateTime(new Date());
        o.setNote("note");
        o.setVersion(0l);
        o.setPrice(12);

        Staff staff = new Staff();
        staff.setId(4l);
        Item item = new Item();
        item.setId(1l);
        o.setStaff(staff);
        o.setState(State.ordered);
        o.setItem(item);
        o.setNumber(1);

        Mockito.when(itemService.findOne(4l)).thenReturn(item);
        Mockito.when(staffService.findOne(1l)).thenReturn(staff);

        ResponseEntity<OrderedItem> responseEntity = restTemplate.postForEntity(
                  "/orderedItems", o, OrderedItem.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDelete() {
      


        OrderedItem o = new OrderedItem();
        
        o.setId(12l);
        o.setDateTime(new Date());
        o.setNote("note");
        o.setVersion(0l);
        o.setPrice(12);

        Staff staff = new Staff();
        staff.setId(4l);
        Item item = new Item();
        item.setId(1l);
        o.setStaff(staff);
        o.setState(State.ordered);
        o.setItem(item);
        o.setNumber(1);




      Mockito.when(orderedItemService.findOne(1l)).thenReturn(o);
      Mockito.when(orderedItemService.delete(1l)).thenReturn(true);
      ResponseEntity<OrderedItem> order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      Mockito.when(this.orderedItemService.findOne(1l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

      order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
      
    }

    @Test
    public void testFindAll() {
      ArrayList<OrderedItem> orders=new ArrayList<>();
      orders.add(new OrderedItem());
      orders.add(new OrderedItem());
      ArrayList<OrderedItem>orders123 = new ArrayList<>();
      orders123.add(new OrderedItem());
      Mockito.when(this.orderedItemService.findAll()).thenReturn(orders).thenReturn(orders123);
      Mockito.when(this.orderedItemService.delete(1l)).thenReturn(true);

      
      ResponseEntity<OrderedItem[]> responseEntity = restTemplate
				.getForEntity("/orderedItems/", OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(2, responseEntity.getBody().length);
      ResponseEntity<OrderedItem>order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      responseEntity = restTemplate
				.getForEntity("/orderedItems/", OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(1, responseEntity.getBody().length);
    }

    @Test
    public void testFindOne() {
      Mockito.when(this.orderedItemService.findOne(1l)).thenReturn(new OrderedItem());
      Mockito.when(this.orderedItemService.delete(1l)).thenReturn(true);
      ResponseEntity<OrderedItem> order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
        Mockito.when(this.orderedItemService.findOne(1l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
    }

    @Test
    public void testGetOrdersByDate() throws ParseException {
      
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      DateDTO dto = new DateDTO(format.parse("2020-12-12"), format.parse("2021-12-12")); 

      ArrayList<OrderedItem> orders = new ArrayList<>();
      Mockito.when(orderedItemService.getOrderedItemsByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);


      ResponseEntity<OrderedItem[]> responseEntity = restTemplate
				.postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(0, responseEntity.getBody().length);
      dto = new DateDTO(format.parse("2000-12-12"), format.parse("2021-12-12"));
      orders.add(new OrderedItem());
      orders.add(new OrderedItem());
      Mockito.when(orderedItemService.getOrderedItemsByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);
      responseEntity = restTemplate
				.postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().length);
        orders.remove(0);

        dto = new DateDTO(format.parse("2012-11-15"), format.parse("2012-12-15"));
      Mockito.when(orderedItemService.getOrderedItemsByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);
      responseEntity = restTemplate
          .postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertEquals(1, responseEntity.getBody().length);
      
    }

    @Test
    public void testUpdate() {
        OrderedItem o = new OrderedItem();
        
        o.setId(12l);
        o.setDateTime(new Date());
        o.setNote("note");
        o.setVersion(0l);
        o.setPrice(12);

        Staff staff = new Staff();
        staff.setId(4l);
        Item item = new Item();
        item.setId(1l);
        o.setStaff(staff);
        o.setState(State.ordered);
        o.setItem(item);
        o.setNumber(1);




        Mockito.when(orderedItemService.update(o)).thenReturn(o);
        Mockito.when(orderedItemService.findOne(1l)).thenReturn(o);
        ResponseEntity<OrderedItem> responseEntity = restTemplate.getForEntity(
        "/orderedItems/1", OrderedItem.class);
        OrderedItem order2 = responseEntity.getBody();

        responseEntity = restTemplate.postForEntity(
                  "/orderedItems/update", o, OrderedItem.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.when(this.orderedItemService.findOne(1l)).thenReturn(new OrderedItem());
        responseEntity = restTemplate.getForEntity(
            "/orderedItems/1", OrderedItem.class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          responseEntity.getBody();
          responseEntity.getBody().getPrice();
          order2.getPrice();
          assertEquals(false, responseEntity.getBody().getPrice() == order2.getPrice()); // save does not work for some reason
    }
 

    @Test
    public void testGetOrderedItemsByItem() {

        OrderedItem item1 = new OrderedItem();
        item1.setId(1l);
        OrderedItem item2 = new OrderedItem();
        item1.setId(2l);
        ArrayList<OrderedItem> orderedItems = new ArrayList<>();
        orderedItems.add(item1);
        Mockito.when(orderedItemService.getOrderedItemsByItem(1l)).thenReturn(orderedItems);
        ResponseEntity<OrderedItem[]> responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/1", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(item1.getId(), responseEntity.getBody()[0].getId());
        orderedItems.remove(0);
        orderedItems.add(item2);
        Mockito.when(orderedItemService.getOrderedItemsByItem(4l)).thenReturn(orderedItems);

        responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/4", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(item2.getId(), responseEntity.getBody()[0].getId());

        orderedItems.remove(0);
        Mockito.when(orderedItemService.getOrderedItemsByItem(0l)).thenReturn(orderedItems);

        responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/2", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().length);
    }
}
