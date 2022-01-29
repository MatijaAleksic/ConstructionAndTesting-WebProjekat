package kts.restaurant_application.repositories;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.OrderedItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static kts.restaurant_application.constants.OrderedItemConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderedItemRepositoryTest {


    @Autowired
    private OrderedItemRepository orderedItemRepository;

    @Test
    public void testFindAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualTrue() throws ParseException {
        String prvi = "2011-11-11";
        String drugi = "2013-11-11";
        Date date_from = new SimpleDateFormat("yyyy-MM-dd").parse(prvi);
        Date date_to = new SimpleDateFormat("yyyy-MM-dd").parse(drugi);
        Collection<OrderedItem> found = orderedItemRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(date_from, date_to);
        assertEquals(6,found.size());
    }

    @Test
    public void testFindAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualTrueFalse() throws ParseException {
        String prvi = "2015-11-11";
        String drugi = "2016-11-11";
        Date date_from = new SimpleDateFormat("yyyy-MM-dd").parse(prvi);
        Date date_to = new SimpleDateFormat("yyyy-MM-dd").parse(drugi);
        Collection<OrderedItem> found = orderedItemRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(date_from, date_to);
        assertFalse("Nema za izabrani datum", found.size() == 2);
    }

    @Test
    public void testFindAllByItemIdTrue() {
        Collection<OrderedItem> found = orderedItemRepository.findAllByItemId(1L);
        assertEquals(2, found.size());
    }

    @Test
    public void testFindAllByItemIdFalse() {
        Collection<OrderedItem> found = orderedItemRepository.findAllByItemId(2L);
        assertEquals(1, found.size());
    }
}
