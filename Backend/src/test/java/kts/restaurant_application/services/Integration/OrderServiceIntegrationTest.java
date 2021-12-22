//package kts.restaurant_application.services.Integration;
//
//import kts.restaurant_application.model.Order;
//import kts.restaurant_application.model.Item;
//import kts.restaurant_application.services.OrderService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.server.ResponseStatusException;
//
//import static kts.restaurant_application.constants.OrderConstants.*;
//import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_ID;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource("classpath:application-test.properties")
//public class OrderServiceIntegrationTest {
//
//    @Autowired
//    private OrderService orderService;
//
//    @Test
//    public void testFindAll() {
//        Iterable<Order> found = orderService.findAll();
//
//        int count = 0;
//        for(Order u : found){
//            count += 1;
//        }
//        assertEquals(FIND_ALL_NUMBER_OF_ORDERS, count);
//    }
//
//    @Test(expected = ResponseStatusException.class)
//    public void testFindOneThrowsResponseStatusException() {
//        orderService.findOne(DB_WRONG_ORDER_ID);
//    }
//
//    @Test
//    public void testFindOne() {
//        Order found = orderService.findOne(DB_ORDER_ID);
//        assertEquals(DB_ORDER_ID, found.getId());
//    }
//
//    @Test
//    public void testSave(){
//
//        Order item = new Order(DB_NEW_ORDER_PRICE, DB_NEW_ORDER_PRIPRITY, DB_NEW_ORDER_SUBCATEGORY, DB_NEW_ORDER_DESCRIPTION, DB_NEW_ORDER_IS_DELETED, DB_NEW_ORDER_NAME);
//
//        Order created = orderService.save(item);
//
//        assertEquals(DB_NEW_ORDER_NAME, created.getName());
//    }
//
//    @Test
//    public void testDelete1(){
//        Order item = orderService.delete(DB_ORDER_ID);
//        assertEquals(true, item.getIsDeleted());
//    }
//
//    @Test
//    public void testDelete2(){
//        Order item = new Order(DB_ORDER_PRICE, DB_ORDER_PRIPRITY, DB_ORDER_SUBCATEGORY, DB_ORDER_DESCRIPTION, DB_ORDER_IS_DELETED, DB_ORDER_NAME);
//        item.setId(DB_ORDER_ID);
//
//        Item tested_ORDER = orderService.delete(item);
//        assertEquals(true, tested_ORDER.getIsDeleted());
//    }
//}
