package kts.restaurant_application.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import kts.restaurant_application.DTO.DateDTO;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.State;
import kts.restaurant_application.repositories.ItemRepository;
import kts.restaurant_application.repositories.OrderedItemRepository;
import kts.restaurant_application.repositories.StaffRepository;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderedItemControllerTest {






    @Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderedItemRepository orderedItemRepository;

    @Test
    public void testCreate() {
        OrderedItem o = new OrderedItem();
        
        o.setId(12l);
        o.setDateTime(new Date());
        o.setNote("note");
        o.setVersion(0l);
        o.setPrice(12.0);
        o.setStaff(staffRepository.findById(4l).get());
        o.setState(State.ordered);
        o.setItem(itemRepository.findById(1l).get());
        o.setNumber(1);

        ResponseEntity<OrderedItem> responseEntity = restTemplate.postForEntity(
                  "/orderedItems", o, OrderedItem.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      responseEntity = restTemplate.postForEntity(
        "/orderedItems", o, OrderedItem.class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // save does not work for some reason
    }

    @Test
    public void testDelete() {
      ResponseEntity<OrderedItem> order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.METHOD_NOT_ALLOWED, order.getStatusCode());
      order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      
    }

    @Test
    public void testFindAll() {

      ResponseEntity<OrderedItem[]> responseEntity = restTemplate
				.getForEntity("/orderedItems/", OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(6, responseEntity.getBody().length);
      ResponseEntity<OrderedItem>order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.METHOD_NOT_ALLOWED, order.getStatusCode());
      responseEntity = restTemplate
				.getForEntity("/orderedItems/", OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(6, responseEntity.getBody().length);
    }

    @Test
    public void testFindOne() {
      ResponseEntity<OrderedItem> order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
      order = restTemplate.postForEntity("/orderedItems/delete/1", 1, OrderedItem.class);
      assertEquals(HttpStatus.METHOD_NOT_ALLOWED, order.getStatusCode());
      order = restTemplate.getForEntity("/orderedItems/1", OrderedItem.class);
      assertEquals(HttpStatus.OK, order.getStatusCode());
    }

    @Test
    public void testGetOrdersByDate() throws ParseException {
      
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      DateDTO dto = new DateDTO(format.parse("2020-12-12"), format.parse("2021-12-12")); //cannot accept the DateDTO for some reason
      ResponseEntity<OrderedItem[]> responseEntity = restTemplate
				.postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
      assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      assertEquals(0, responseEntity.getBody().length);
      dto = new DateDTO(format.parse("2000-12-12"), format.parse("2021-12-12"));
      responseEntity = restTemplate
				.postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(6, responseEntity.getBody().length);

        dto = new DateDTO(format.parse("2012-11-15"), format.parse("2012-12-15"));
        responseEntity = restTemplate
          .postForEntity("/orderedItems/getOrderedItemsByDate", dto, OrderedItem[].class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertEquals(3, responseEntity.getBody().length);
      
    }

    @Test
    public void testUpdate() {
        OrderedItem o = new OrderedItem();
        
        o.setId(1l);
        o.setDateTime(new Date());
        o.setNote("note");
        o.setVersion(0l);
        o.setPrice(333.0);
        o.setStaff(staffRepository.findById(4l).get());
        o.setState(State.ordered);
        o.setItem(itemRepository.findById(1l).get());
        o.setNumber(1);
        ResponseEntity<OrderedItem> responseEntity = restTemplate.getForEntity(
        "/orderedItems/1", OrderedItem.class);
        OrderedItem order2 = responseEntity.getBody();

        responseEntity = restTemplate.postForEntity(
                  "/orderedItems/update", o, OrderedItem.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        responseEntity = restTemplate.getForEntity(
            "/orderedItems/1", OrderedItem.class);
          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
          assertEquals(false, responseEntity.getBody().getPrice() == order2.getPrice()); // save does not work for some reason
    }
 

    @Test
    public void testGetOrderedItemsByItem() {

        OrderedItem item1 = orderedItemRepository.findById(1l).get();
        OrderedItem item2 = orderedItemRepository.findById(2l).get();

        ResponseEntity<OrderedItem[]> responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/1", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(item1.getId(), responseEntity.getBody()[0].getId());

        responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/4", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(item2.getId(), responseEntity.getBody()[0].getId());
        responseEntity = restTemplate.getForEntity("/orderedItems/getOrderedItemsByItem/2", OrderedItem[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().length);
    }
}
