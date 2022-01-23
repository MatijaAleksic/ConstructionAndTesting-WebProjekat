package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.OrderedItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static kts.restaurant_application.constants.OrderedItemConstants.ORDERED_ITEM_DATETIME_FROM;
import static kts.restaurant_application.constants.OrderedItemConstants.ORDERED_ITEM_DATETIME_TO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderRepositoryTest {

    @Autowired
    public OrderRepository orderRepository;

    @Test
    public void testFindAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualFalse() throws ParseException {
        String prvi = "2015-11-11";
        String drugi = "2016-11-11";
        Date date_from = new SimpleDateFormat("yyyy-MM-dd").parse(prvi);
        Date date_to = new SimpleDateFormat("yyyy-MM-dd").parse(drugi);
        Collection<Order> found = orderRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(date_from, date_to);
        assertFalse("Nema za izabrani datum", found.size() == 2);
    }

    @Test
    public void testFindAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualTrue() throws ParseException {
        String prvi = "2011-11-11";
        String drugi = "2013-11-11";
        Date date_from = new SimpleDateFormat("yyyy-MM-dd").parse(prvi);
        Date date_to = new SimpleDateFormat("yyyy-MM-dd").parse(drugi);
        Collection<Order> found = orderRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(date_from, date_to);
        assertEquals(2,found.size());
    }
}
