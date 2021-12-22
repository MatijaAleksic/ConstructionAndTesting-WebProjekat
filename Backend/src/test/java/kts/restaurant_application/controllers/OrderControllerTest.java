package kts.restaurant_application.controllers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderControllerTest {



    @Autowired
	private TestRestTemplate restTemplate;



    @Test
    public void testCreate() {
    //     Waiter w = new Waiter();
    //     w.setId(12l);
    //     RestourantTables t = new RestourantTables();
    //     t.setId(1l);
    //     Order newAdmin =  new Order(99l, 0l, 11.11, "note", w, table, food, new Date());

    //     ResponseEntity<Order> responseEntity = restTemplate.postForEntity(
    //               "/orders", newAdmin, Order.class);
    //       assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    //   responseEntity = restTemplate.postForEntity(
    //     "/orders", newAdmin, Order.class);
    //       assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
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
    public void testGetOrdersByDate() {

    }

    @Test
    public void testUpdate() {

    }
}
