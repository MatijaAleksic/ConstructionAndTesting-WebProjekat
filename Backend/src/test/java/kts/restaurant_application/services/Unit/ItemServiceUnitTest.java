package kts.restaurant_application.services.Unit;

import kts.restaurant_application.model.Item;
import kts.restaurant_application.repositories.ItemRepository;
import kts.restaurant_application.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kts.restaurant_application.constants.ItemConstants.*;
import static kts.restaurant_application.constants.ItemConstants.DB_WRONG_ITEM_ID;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ItemServiceUnitTest {

    @Autowired
    private ItemService ItemService;

    @MockBean
    private ItemRepository ItemRepository;

    @Test
    public void testFindAll() {
        List<Item> Items = new ArrayList<>();

        Item item = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item Item2 = new Item(DB_ITEM_PRICE_UNIT1, DB_ITEM_PRIPRITY_UNIT1, DB_ITEM_SUBCATEGORY_UNIT1, DB_ITEM_DESCRIPTION_UNIT1, DB_ITEM_IS_DELETED_UNIT1, DB_ITEM_NAME_UNIT1);
        Item Item3 = new Item(DB_ITEM_PRICE_UNIT2, DB_ITEM_PRIPRITY_UNIT2, DB_ITEM_SUBCATEGORY_UNIT2, DB_ITEM_DESCRIPTION_UNIT2, DB_ITEM_IS_DELETED_UNIT2, DB_ITEM_NAME_UNIT2);
        Items.add(item);
        Items.add(Item2);
        Items.add(Item3);

        given(ItemRepository.findAll()).willReturn(Items);

        Iterable<Item> found = ItemService.findAll();

        int count = 0;
        for(Item u : found){
            count += 1;
        }
        assertEquals(FIND_ALL_NUMBER_OF_ITEM_UNIT, count);
    }


    @Test(expected = ResponseStatusException.class)
    public void testFindOneThrowsResponseStatusException() {
        given(ItemRepository.findById(DB_WRONG_ITEM_ID))
                .willThrow(ResponseStatusException.class);


        ItemService.findOne(DB_WRONG_ITEM_ID);
    }

    @Test
    public void testFindOne() {
        Item Item1 = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item1.setId(DB_ITEM_ID);

        Mockito.when(ItemRepository.findById(DB_ITEM_ID))
                .thenReturn(java.util.Optional.of(Item1));

        Item found = ItemService.findOne(DB_ITEM_ID);
        assertEquals(DB_ITEM_ID, found.getId());
    }

    @Test
    public void testSave(){
        Item Item1 = new Item(DB_NEW_ITEM_PRICE, DB_NEW_ITEM_PRIPRITY, DB_NEW_ITEM_SUBCATEGORY, DB_NEW_ITEM_DESCRIPTION, DB_NEW_ITEM_IS_DELETED, DB_NEW_ITEM_NAME);

        given(ItemRepository.save(Item1)).willReturn(Item1);

        Item created = ItemService.save(Item1);

        assertEquals(DB_NEW_ITEM_NAME, created.getName());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete1ShouldReturnResponseStatusException(){
        Item Item1 = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item1.setId(DB_ITEM_ID);

        Mockito.when(ItemRepository.findById(DB_ITEM_ID)).thenThrow(ResponseStatusException.class);

        Item Item = ItemService.delete(DB_ITEM_ID);
    }

    @Test
    public void testDelete1(){
        Item Item1 = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item1.setId(DB_ITEM_ID);

        Mockito.when(ItemRepository.findById(DB_ITEM_ID)).thenReturn(Optional.of(Item1));

        Item deletedItem = Item1;
        deletedItem.setIsDeleted(true);

        Mockito.when(ItemRepository.save(Item1)).thenReturn(deletedItem);

        Item Item = ItemService.delete(DB_ITEM_ID);

        assertEquals(true, Item.getIsDeleted());
    }



    @Test
    public void testDelete2(){
        Item Item1 = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item1.setId(DB_ITEM_ID);

        given(ItemRepository.findById(DB_ITEM_ID)).willReturn(java.util.Optional.of(Item1));

        Item deletedItem = Item1;
        deletedItem.setIsDeleted(true);

        Mockito.when(ItemRepository.save(Item1)).thenReturn(deletedItem);

        Item tested_ITEM = ItemService.delete(Item1);
        assertEquals(true, tested_ITEM.getIsDeleted());
    }

    @Test(expected = ResponseStatusException.class)
    public void testDelete2ShouldReturnResponseStatusException(){
        Item Item1 = new Item(DB_ITEM_PRICE, DB_ITEM_PRIPRITY, DB_ITEM_SUBCATEGORY, DB_ITEM_DESCRIPTION, DB_ITEM_IS_DELETED, DB_ITEM_NAME);
        Item1.setId(DB_WRONG_ITEM_ID);

        Mockito.when(ItemRepository.findById(DB_WRONG_ITEM_ID)).thenThrow(ResponseStatusException.class);

        Item tested_ITEM = ItemService.delete(Item1);
    }
}
