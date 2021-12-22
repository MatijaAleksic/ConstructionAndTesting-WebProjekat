package kts.restaurant_application.controllers;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.model.DateDTO;
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.repositories.OrderedItemRepository;
import kts.restaurant_application.repositories.TableRepository;
import kts.restaurant_application.repositories.WaiterRepository;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderControllerTest {



    @Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private WaiterRepository waiterRepository;

    @Autowired
    private OrderedItemRepository orderedItemRepository;

    @Autowired
    private TableRepository tableRepository;

    @Test
    public void testCreate() {
        Order o = new Order();
        o.setId(12l);
        o.setDateTime(new Date());
        o.setPrice(22.22);
        o.setVersion(0l);
        o.setWaiter(waiterRepository.findById(12l).get());
        HashSet<OrderedItem> set = new HashSet<OrderedItem>();
        set.add(orderedItemRepository.findById(1l).get());
        o.setFood(set);
        o.setRestourantTable(tableRepository.findById(1l).get());


        ResponseEntity<Order> responseEntity = restTemplate.postForEntity(
                  "/orders", o, Order.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      responseEntity = restTemplate.postForEntity(
        "/orders", o, Order.class);
          assertEquals(HttpStatus.ALREADY_REPORTED, responseEntity.getStatusCode()); // save does not work for some reason
    }

    @Test
    public void testDelete() {
      ResponseEntity<Order> order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
      
    }

    @Test
    public void testFindAll() {

      ResponseEntity<Order[]> responseEntity = restTemplate
				.getForEntity("/orders/", Order[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(2, responseEntity.getBody().length);
      ResponseEntity<Order>order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      responseEntity = restTemplate
				.getForEntity("/orders/", Order[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(1, responseEntity.getBody().length);
    }

    @Test
    public void testFindOne() {
      ResponseEntity<Order> order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orders/delete/1", 1, Order.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.getForEntity("/orders/1", Order.class);
      assertEquals(HttpStatus.NOT_FOUND, order.getStatusCode());
    }

    @Test
    public void testGetOrdersByDate() throws ParseException {
      
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      DateDTO dto = new DateDTO(format.parse("2020-12-12"), format.parse("2021-12-12")); //cannot accept the DateDTO for some reason
      ResponseEntity<Order[]> responseEntity = restTemplate
				.postForEntity("/orders/getOrdersByDate", dto, Order[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(0, responseEntity.getBody().length);
      dto = new DateDTO(format.parse("2000-12-12"), format.parse("2021-12-12"));
      responseEntity = restTemplate
				.postForEntity("/orders/getOrdersByDate", dto, Order[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().length);

        dto = new DateDTO(format.parse("2012-11-15"), format.parse("2012-12-15"));
        responseEntity = restTemplate
          .postForEntity("/orders/getOrdersByDate", dto, Order[].class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertEquals(1, responseEntity.getBody().length);
      
    }

    @Test
    public void testUpdate() {
      Order o = new Order();
        o.setId(1l);
        o.setDateTime(new Date());
        o.setPrice(22.22);
        o.setVersion(0l);
        o.setWaiter(waiterRepository.findById(12l).get());
        HashSet<OrderedItem> set = new HashSet<OrderedItem>();
        set.add(orderedItemRepository.findById(1l).get());
        o.setFood(set);
        o.setRestourantTable(tableRepository.findById(1l).get());
        ResponseEntity<Order> responseEntity = restTemplate.getForEntity(
        "/orders/1", Order.class);
        Order order2 = responseEntity.getBody();
        responseEntity = restTemplate.postForEntity(
                  "/orders/update", o, Order.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      responseEntity = restTemplate.getForEntity(
        "/orders/1", Order.class);
          assertEquals(false, responseEntity.getBody().getPrice() == order2.getPrice()); // save does not work for some reason
    }
}
