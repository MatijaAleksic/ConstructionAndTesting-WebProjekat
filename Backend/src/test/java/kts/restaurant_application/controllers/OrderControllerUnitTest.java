package kts.restaurant_application.controllers;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

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
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.services.OrderService;
import kts.restaurant_application.services.OrderedItemService;
import kts.restaurant_application.services.TableService;
import kts.restaurant_application.services.WaiterService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerUnitTest {



    @Autowired
	private TestRestTemplate restTemplate;

    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderedItemService orderedItemService;
    @MockBean
    private WaiterService waiterService;
    @MockBean
    private TableService restourantTables;
    @Test
    public void testCreate() {
        Order o = new Order();
        o.setId(12l);
        o.setDateTime(new Date());
        o.setPrice(22.22);
        o.setVersion(0l);
        Waiter w = new Waiter();
        w.setId(1l);
        o.setWaiter(w);
        HashSet<OrderedItem> set = new HashSet<OrderedItem>();
        OrderedItem ord = new OrderedItem();
        ord.setId(1l);
        set.add(new OrderedItem());
        o.setFood(set);
        RestourantTables t = new RestourantTables();
        t.setId(1l);
        o.setRestourantTable(t);

        Mockito.when(orderService.save(o)).thenReturn(o);
        Mockito.when(waiterService.findOne(1l)).thenReturn(w);
        Mockito.when(orderedItemService.findOne(1l)).thenReturn(ord);
        Mockito.when(restourantTables.findOne(1l)).thenReturn(t);
        
        ResponseEntity<Order> responseEntity = restTemplate.postForEntity(
                  "/orders", o, Order.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.when(orderService.save(o)).thenThrow(new ResponseStatusException(HttpStatus.ALREADY_REPORTED));

      responseEntity = restTemplate.postForEntity(
        "/orders", o, Order.class);
          assertEquals(HttpStatus.ALREADY_REPORTED, responseEntity.getStatusCode()); // save does not work for some reason
    }

    @Test
    public void testDelete() {
        Mockito.when(this.orderService.delete(1l)).thenReturn(true);
        Mockito.when(this.orderService.findOne(1l)).thenReturn(new Order());

      ResponseEntity<Order> order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      Mockito.when(this.orderService.findOne(1l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

      order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
      
    }

    @Test
    public void testFindAll() {
        ArrayList<Order> orders=new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        ArrayList<Order>orders123 = new ArrayList<>();
        orders123.add(new Order());
        Mockito.when(this.orderService.findAll()).thenReturn(orders).thenReturn(orders123);
        
      ResponseEntity<Order[]> responseEntity = restTemplate
				.getForEntity("/orders/", Order[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(2, responseEntity.getBody().length);
        Mockito.when(this.orderService.delete(1l)).thenReturn(true);
        ResponseEntity<Order>order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      responseEntity = restTemplate
				.getForEntity("/orders/", Order[].class);
    
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(1, responseEntity.getBody().length);
    }

    @Test
    public void testFindOne() {
        Mockito.when(this.orderService.findOne(1l)).thenReturn(new Order());
        Mockito.when(this.orderService.delete(1l)).thenReturn(true);
        ResponseEntity<Order> order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
        Mockito.when(this.orderService.findOne(1l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
        order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
    }

    @Test
    public void testGetOrdersByDate() throws ParseException {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      DateDTO dto = new DateDTO(format.parse("2020-12-12"), format.parse("2021-12-12")); //cannot accept the DateDTO for some reason

      ArrayList<Order> orders = new ArrayList<>();
      Mockito.when(orderService.getOrdersByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);

      ResponseEntity<Order[]> responseEntity = restTemplate
				.postForEntity("/orders/getOrdersByDate", dto, Order[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(0, responseEntity.getBody().length);
      dto = new DateDTO(format.parse("2000-12-12"), format.parse("2021-12-12"));
      Mockito.when(orderService.getOrdersByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);

      orders.add(new Order());
        orders.add(new Order());
      responseEntity = restTemplate
				.postForEntity("/orders/getOrdersByDate", dto, Order[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().length);

        orders.remove(0);
        dto = new DateDTO(format.parse("2012-11-15"), format.parse("2012-12-15"));
      Mockito.when(orderService.getOrdersByDate(dto.dateFrom, dto.dateTo)).thenReturn(orders);

        responseEntity = restTemplate
          .postForEntity("/orders/getOrdersByDate", dto, Order[].class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertEquals(1, responseEntity.getBody().length);
      
    }

    @Test
    public void testUpdate() {
        Order o = new Order();
        o.setId(12l);
        o.setDateTime(new Date());
        o.setPrice(22.22);
        o.setVersion(0l);
        o.setWaiter(new Waiter());
        HashSet<OrderedItem> set = new HashSet<OrderedItem>();
        set.add(new OrderedItem());
        o.setFood(set);
        o.setRestourantTable(new RestourantTables());

        Mockito.when(orderService.update(o)).thenReturn(o);
        Mockito.when(this.orderService.findOne(1l)).thenReturn(o);

        ResponseEntity<Order> responseEntity = restTemplate.getForEntity(
        "/orders/1", Order.class);
        Order order2 = responseEntity.getBody();
        responseEntity = restTemplate.postForEntity(
                  "/orders/update", o, Order.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Mockito.when(this.orderService.findOne(1l)).thenReturn(new Order());

      responseEntity = restTemplate.getForEntity(
        "/orders/1", Order.class);
          assertEquals(false, responseEntity.getBody().getPrice() == order2.getPrice());
    }
}
