package kts.restaurant_application.controllers;


import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kts.restaurant_application.DTO.DateDTO;
import kts.restaurant_application.model.Item;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.Staff;
import kts.restaurant_application.services.ItemService;
import kts.restaurant_application.services.OrderedItemService;
import kts.restaurant_application.services.StaffService;

@Transactional
@RestController
@RequestMapping("/orderedItems")
public class OrderedItemController {
    private static final Logger logger = LoggerFactory.getLogger(OrderedItemController.class);

    private final OrderedItemService service;
    private final StaffService staffService;
    private final ItemService itemService;

    @Autowired
    public OrderedItemController(OrderedItemService service, StaffService staffService, ItemService itemService) {
        this.service = service;
        this.staffService = staffService;
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<OrderedItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/staff")
    public Iterable<OrderedItem> findAllOrdered() {
        return service.findAllOrdered();
    }

    @GetMapping("/staff/{id}")
    public Iterable<OrderedItem> findAllStaff(@PathVariable("id") Long id) {
        return service.findAllByStaff(id);
    }


    @GetMapping("/{id}")
    public OrderedItem findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public OrderedItem create(@RequestBody @Valid OrderedItem entity) {

        
        Item item = itemService.findOne(entity.getItem().getId());
        Staff staff = null;
        try{
            staff = staffService.findOne(entity.getStaff().getId());
        } catch(Exception e){

        }
        System.out.println("Item id: " + item.getId());
        entity.setItem(item);
        entity.setStaff(staff);
        return service.save(entity);
    }

    @PostMapping("/update")
    public OrderedItem update(@RequestBody OrderedItem entity){
        Item item = itemService.findOne(entity.getItem().getId());
        Staff staff = null;

        try{
            staff = staffService.findOne(entity.getStaff().getId());
        }catch(Exception e){
            
        }
        entity.setItem(item);
        entity.setStaff(staff);
        return service.update(entity);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        
        service.delete(id);
    }


    @GetMapping("/getOrderedItemsByItem/{itemId}")
    public Collection<OrderedItem> getOrderedItemsByItem(@PathVariable Long itemId){
        

        return service.getOrderedItemsByItem(itemId);
        
    }

    @PostMapping("/getOrderedItemsByDate")
    public Collection<OrderedItem> getOrdersByDate(@RequestBody DateDTO data){
        Date dateFrom = data.dateFrom;
        Date dateTo = data.dateTo;

        return service.getOrderedItemsByDate(dateFrom, dateTo);
        
    }

}