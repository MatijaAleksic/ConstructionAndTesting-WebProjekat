package kts.restaurant_application.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import kts.restaurant_application.model.Order;
import kts.restaurant_application.model.OrderDTO;
import kts.restaurant_application.model.OrderedItem;
import kts.restaurant_application.model.RestourantTables;
import kts.restaurant_application.model.Waiter;
import kts.restaurant_application.services.OrderService;
import kts.restaurant_application.services.OrderedItemService;
import kts.restaurant_application.services.TableService;
import kts.restaurant_application.services.WaiterService;

@Transactional
@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService service;
    private final TableService tableService;
    private final WaiterService waiterService;
    private final OrderedItemService orderedItemService;

    @Autowired
    public OrderController(OrderService service, TableService t, WaiterService w, OrderedItemService itemService) {
        this.service = service;
        this.tableService = t;
        this.waiterService = w;
        this.orderedItemService = itemService;
    }

    @GetMapping
    public Iterable<Order> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Order create(@RequestBody @Valid OrderDTO entityDto) {
        System.out.println("Enitty: " + entityDto.toString());
        System.out.println("Enitty: " + entityDto.getClass().toString());
        Order entity = new Order();
        entity.setDateTime(new Date());
        entity.setPrice(entityDto.price);

        RestourantTables t = tableService.findOne(entityDto.restourantTable);
        Waiter w = waiterService.findOne(entityDto.waiter);
        Set<OrderedItem> food = new HashSet<OrderedItem>();

        for(Long item : entityDto.orderedItems){
            OrderedItem foundItem = orderedItemService.findOne(item);
            food.add(foundItem);
        }
        entity.setFood(food);
        entity.setRestourantTable(t);
        entity.setWaiter(w);
        return service.save(entity);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order entity){
        RestourantTables t = tableService.findOne(entity.getRestourantTable().getId());
        Waiter w = waiterService.findOne(entity.getWaiter().getId());
        entity.setRestourantTable(t);
        entity.setWaiter(w);
        return service.update(entity);
    }

    @PostMapping("/getOrdersByDate")
    public Collection<Order> getOrdersByDate(@RequestBody DateDTO data){
        System.out.println("AAAAAAAAAAA");
        Date dateFrom = data.dateFrom;
        Date dateTo = data.dateTo;

        return service.getOrdersByDate(dateFrom, dateTo);
        
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @GetMapping("/getOrderByTable/{id}")
    public Order getOrderByTable(@PathVariable Long id){
        return service.getOrderByTable(id);
    }

    @GetMapping("/getOrdersByTable/{id}")
    public Collection<Order> getOrdersByTable(@PathVariable Long id){
        return service.getOrdersByTable(id);
    }
}