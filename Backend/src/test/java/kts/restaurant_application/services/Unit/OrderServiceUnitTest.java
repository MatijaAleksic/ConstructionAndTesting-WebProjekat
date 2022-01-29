package kts.restaurant_application.services.Unit;

import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_DATETIME;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_DATETIME_UNIT1;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_ID;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_NOTE;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_NOTE_UNIT1;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_PRICE;
import static kts.restaurant_application.constants.OrderConstants.DB_ORDER_PRICE_UNIT1;
import static kts.restaurant_application.constants.OrderConstants.DB_WRONG_ORDER_ID;
import static kts.restaurant_application.constants.OrderConstants.FIND_ALL_NUMBER_OF_ORDER_TABLE_UNIT;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_FLOOR;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_ID;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_IS_DELETED;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_X;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_POSITION_Y;
import static kts.restaurant_application.constants.ResourantTablesConstants.DB_RESTOURANT_TABLE_STATE;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_DATE_OF_BIRTH;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_FIRSTNAME;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_ID;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_IS_DELETED;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_LASTNAME;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_PASSWORD;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_SALARY;
import static kts.restaurant_application.constants.WaiterConstants.DB_WAITER_USERNAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.repositories.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderServiceUnitTest {

    @Autowired
    private kts.restaurant_application.services.OrderService OrderService;

    @MockBean
    private OrderRepository OrderRepository;

    @Test
    public void testFindAll() {
        List<Order> Orders = new ArrayList<>();

        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);
        Order Order2 = new Order(DB_ORDER_PRICE_UNIT1, DB_ORDER_NOTE_UNIT1, waiter, restorantTables, DB_ORDER_DATETIME_UNIT1);
        Order Order3 = new Order(DB_ORDER_PRICE_UNIT1, DB_ORDER_NOTE_UNIT1, waiter, restorantTables, DB_ORDER_DATETIME_UNIT1);
        Orders.add(Order1);
        Orders.add(Order2);
        Orders.add(Order3);

        given(OrderRepository.findAll()).willReturn(Orders);

        Iterable<Order> found = OrderService.findAll();

        int count = 0;
        for(Order u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ORDER_TABLE_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(OrderRepository.findById(DB_WRONG_ORDER_ID))
                .willThrow(ResponseStatusException.class);


        OrderService.findOne(DB_WRONG_ORDER_ID);
    }

    @Test
    public void testFindOne() {
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);        Order1.setId(DB_ORDER_ID);

        Mockito.when(OrderRepository.findById(DB_ORDER_ID))
                .thenReturn(java.util.Optional.of(Order1));

        Order found = OrderService.findOne(DB_ORDER_ID);
        assertEquals(DB_ORDER_ID, found.getId());
    }

    @Test
    public void testSave(){
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);
        given(OrderRepository.save(Order1)).willReturn(Order1);

        Order created = OrderService.save(Order1);

        assertEquals(DB_ORDER_PRICE, created.getPrice());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);        Order1.setId(DB_ORDER_ID);

        Mockito.when(OrderRepository.findById(DB_ORDER_ID)).thenThrow(ResponseStatusException.class);

        boolean Order = OrderService.delete(DB_ORDER_ID);
    }

    @Test
    public void testDelete1(){
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);        Order1.setId(DB_ORDER_ID);

        Mockito.when(OrderRepository.findById(DB_ORDER_ID)).thenReturn(Optional.of(Order1));


        boolean Order = OrderService.delete(DB_ORDER_ID);

        assertTrue(Order);
    }



    @Test
    public void testDelete2(){
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);        Order1.setId(DB_ORDER_ID);

        given(OrderRepository.findById(DB_ORDER_ID)).willReturn(java.util.Optional.of(Order1));

        boolean tested_RESTOURNAT_TABLE = OrderService.delete(Order1);
        assertTrue(tested_RESTOURNAT_TABLE);
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        RestourantTables restorantTables = new RestourantTables( DB_RESTOURANT_TABLE_FLOOR, DB_RESTOURANT_TABLE_POSITION_X, DB_RESTOURANT_TABLE_POSITION_Y, DB_RESTOURANT_TABLE_STATE, DB_RESTOURANT_TABLE_IS_DELETED);
        restorantTables.setId(DB_RESTOURANT_TABLE_ID);

        Waiter waiter = new Waiter(DB_WAITER_FIRSTNAME, DB_WAITER_LASTNAME, DB_WAITER_USERNAME, DB_WAITER_PASSWORD, DB_WAITER_DATE_OF_BIRTH, DB_WAITER_SALARY, DB_WAITER_IS_DELETED);
        waiter.setId(DB_WAITER_ID);

        Order Order1 = new Order(DB_ORDER_PRICE, DB_ORDER_NOTE, waiter, restorantTables, DB_ORDER_DATETIME);        Order1.setId(DB_ORDER_ID);

        Mockito.when(OrderRepository.findById(DB_ORDER_ID)).thenThrow(ResponseStatusException.class);
        doNothing().when(OrderRepository).delete(Order1);

        boolean tested_RESTOURNAT_TABLE = OrderService.delete(Order1);
    }
}
