package kts.restaurant_application.repositories;

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

import javax.validation.constraints.NotNull;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class OrderedItemRepositoryTest {


    @Autowired
    private OrderedItemRepository orderedItemRepository;


    @Test
    public void testFindAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual() {
        Collection<OrderedItem> found = orderedItemRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(ORDERED_ITEM_DATETIME_FROM, ORDERED_ITEM_DATETIME_TO);
        assertEquals(2, found.size());
    }

    @Test
    public void testFindAllByItemId() {
        Collection<OrderedItem> found = orderedItemRepository.findAllByItemId(1L);
        assertEquals(1, found.size());
    }
}
