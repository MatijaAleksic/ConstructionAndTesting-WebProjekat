package kts.restaurant_application.services.Integration;

import kts.restaurant_application.model.*;
import kts.restaurant_application.services.OrderService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static kts.restaurant_application.constants.OrderConstants.*;
import static kts.restaurant_application.constants.ResourantTablesConstants.*;
import static kts.restaurant_application.constants.WaiterConstants.*;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;


    @Test()
    public void AtestFindAll() {
        Iterable<Order> found = orderService.findAll();

        int count = 0;
        for (Order u : found) {
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ORDERS, count);
    }

    @Test(expected = ResponseStatusException.class)
    public void BtestFindOneThrowsResponseStatusException() {
        orderService.findOne(DB_WRONG_ORDER_ID);
    }

    @Test
    public void CtestFindOne() {
        Order found = orderService.findOne(DB_ORDER_ID);
        assertEquals(DB_ORDER_ID, found.getId());
    }

    @Test
    public void DtestSave() {
//        RestourantTables restorantTables = new RestourantTables(DB_RESTOURANT_TABLE_NUMBER, DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
//        restorantTables.setId(DB_RESTOURANT_TABLE_ID);
//
//        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
//        waiter.setId(DB_WAITER_ID);

        Order item = new Order(DB_ORDER_PRICE, DB_ORDER_DATETIME);

        Order created = orderService.save(item);

        assertEquals(DB_NEW_ORDER_ID, created.getId());
    }

    @Test
    public void EtestDelete1ShouldReturnTrue() {
        boolean flag = orderService.delete(DB_ORDER_ID2);
        assertTrue(flag);
    }

    @Test(expected = ResponseStatusException.class)
    public void FtestDelete1ShouldReturnReturnResponseStatusException() {
        boolean flag = orderService.delete(DB_WRONG_ORDER_ID);
        assertTrue(flag);
    }


    @Test
    public void GtestDelete2() {
        RestourantTables restorantTables = new RestourantTables(DB_RESTOURANT_TABLE_NUMBER, DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order item = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);
        item.setId(DB_ORDER_ID);

        boolean flag = orderService.delete(item);
        assertTrue(flag);
    }
}
